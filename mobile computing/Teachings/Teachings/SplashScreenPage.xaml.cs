using System;
using Microsoft.Maui.Controls;

namespace Teachings
{
    public partial class SplashScreenPage : ContentPage
    {
        public SplashScreenPage()
        {
            InitializeComponent();
        }

        protected override async void OnAppearing()
        {
            base.OnAppearing();

            // Animate the label to fade in
            await WelcomeLabel.FadeTo(1, 2000); // Duration of 2000 ms (2 seconds)

            // Animate the button to scale up with a bounce effect
            await GetStartedButton.ScaleTo(1, 2000, Easing.BounceOut); // Duration of 2000 ms (2 seconds)
        }

        private async void OnGetStartedClicked(object sender, EventArgs e)
        {
            // Pushing a new page onto the navigation stack
            await Navigation.PushAsync(new WelcomePage());
        }

        private void OnButtonPressed(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            button.BackgroundColor = Color.FromHex("#388E3C"); // Change to pressed color
        }
    }
}

