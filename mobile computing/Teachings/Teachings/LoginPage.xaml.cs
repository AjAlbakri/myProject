using Microsoft.Maui.Controls;
using System;
using System.Collections.Generic;
using System.IO;
using System.Threading.Tasks;

namespace Teachings
{
    public partial class LoginPage : ContentPage
    {

        private bool isPictureTaken = false;
        private static readonly Dictionary<string, string> _users = new Dictionary<string, string>
        {
            { "admin", "password" },
            { "cjabaar15", "kinaaz123" }
        };

        public LoginPage()
        {
            InitializeComponent();
            AddBackButton(); // Call a method to add the back button
        }

        private async void AddBackButton()
        {
            // Create a toolbar item with a back arrow icon
            var backButton = new ToolbarItem
            {
                IconImageSource = "back_arrow_icon.png", // Set the back arrow icon image source
                Priority = 0,
                Order = ToolbarItemOrder.Primary,
                AutomationId = "BackButton"
            };

            // Handle the click event of the back button
            backButton.Clicked += OnBackButtonClicked;

            // Add the back button to the page's toolbar items
            ToolbarItems.Add(backButton);
        }

        private async void OnBackButtonClicked(object sender, EventArgs e)
        {
            await Navigation.PopAsync(); // Navigate back 
        }

        private async void OnLoginClicked(object sender, EventArgs e)
        {
            var username = UsernameEntry.Text?.Trim();
            var password = PasswordEntry.Text?.Trim();

            if (ValidateUser(username, password))
            {
                // Navigate to the profile section if login is successful.
                ShowProfileSection();
            }
            else
            {
                // Display an error message if login fails.
                await DisplayAlert("Login Failed", "Invalid username or password.", "OK");
            }
        }

        private async void OnLogoutClicked(object sender, EventArgs e)
        {
            // Hide profile section
            HideProfileSection();

            // Clear username and password fields
            UsernameEntry.Text = "";
            PasswordEntry.Text = "";
        }

        private void ShowProfileSection()
        {
            // Show profile section elements
            ProfileFrame.IsVisible = true;
            CaptureButton.IsVisible = true;
            NextButton.IsVisible = true;
            LogoutButton.IsVisible = true;

            // Hide login section elements
            UsernameEntry.IsVisible = false;
            PasswordEntry.IsVisible = false;
            LoginButton.IsVisible = false;
        }

        private void HideProfileSection()
        {
            // Hide profile section elements
            ProfileFrame.IsVisible = false;
            CaptureButton.IsVisible = false;
            NextButton.IsVisible = false;
            LogoutButton.IsVisible = false;

            // Show login section elements
            UsernameEntry.IsVisible = true;
            PasswordEntry.IsVisible = true;
            LoginButton.IsVisible = true;
        }

        private bool ValidateUser(string username, string password)
        {
            if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
            {
                Vibration.Default.Vibrate(100);
                return false;
            }

            if (_users.TryGetValue(username, out var storedPassword) && storedPassword == password)
            {
                return true;
            }
            else
            {
                // Vibrate if the username or password is incorrect
                Vibration.Default.Vibrate(1000);
                return false;
            }
        }


        async void OnCapturePhotoClicked(object sender, EventArgs e)
        {
            if (MediaPicker.Default.IsCaptureSupported)
            {
                FileResult myPhoto = await MediaPicker.Default.CapturePhotoAsync();

                if (myPhoto != null)
                {
                    string localFilepath = Path.Combine(FileSystem.CacheDirectory, myPhoto.FileName);
                    using (Stream sourceStream = await myPhoto.OpenReadAsync())
                    {
                        using (FileStream localFileStream = File.OpenWrite(localFilepath))
                        {
                            await sourceStream.CopyToAsync(localFileStream);
                        }
                    }

                    // Show the "Next" button
                    NextButton.IsVisible = true;
                    NextButton.IsEnabled = true;

                    // Set the flag indicating that a picture is taken
                    isPictureTaken = true;
                }
            }
            else
            {
                await DisplayAlert("Oops", "Your device isn't supported for capturing photos.", "OK");
            }
        }

        private async void OnNavigateToLoginPageClicked(object sender, EventArgs e)
        {
            if (isPictureTaken)
            {
                // Navigate to the home page
                await Navigation.PushAsync(new HomePage());
            }
            else
            {
                // Display an alert if the picture is not taken
                await DisplayAlert("Alert", "Please take a picture first.", "OK");
            }
        }
    }
}




