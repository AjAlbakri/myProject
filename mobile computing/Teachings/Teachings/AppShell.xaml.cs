using Microsoft.Maui.Controls;
using System;

namespace Teachings
{
    public partial class AppShell : Shell
    {
        public AppShell()
        {
            InitializeComponent();

            // Registering routes
            // Routing.RegisterRoute(nameof(SplashScreenPage), typeof(SplashScreenPage));
            // Routing.RegisterRoute(nameof(IntoPage), typeof(IntoPage));
            // Routing.RegisterRoute(nameof(WelcomePage), typeof(WelcomePage));
            // Routing.RegisterRoute(nameof(LoginPage), typeof(LoginPage));
            // Routing.RegisterRoute(nameof(HomePage), typeof(HomePage));
            // Routing.RegisterRoute(nameof(ProfilPage), typeof(ProfilPage));
           // Routing.RegisterRoute(nameof(ProfilPage), typeof(QuizzQuestion));
          //  Routing.RegisterRoute(nameof(ProfilPage), typeof(TestKnowledgePage));
        }

      

        private async void OnBackButtonClicked(object sender, EventArgs e)
        {
            await Shell.Current.Navigation.PopAsync(); // Navigate back to the previous page
        }
    }
}
