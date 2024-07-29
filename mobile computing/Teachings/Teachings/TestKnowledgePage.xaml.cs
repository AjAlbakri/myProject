using Microsoft.Maui.Controls;
using System;

namespace Teachings
{
    public partial class TestKnowledgePage : ContentPage
    {
        public TestKnowledgePage()
        {
            InitializeComponent();
        }

        private async void OnEasyClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new EasyQuizess()); // Placeholder action for Easy button
        }

        private async void OnMediumClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new MyQuizzPage2()); // Placeholder action for Medium button
        }

        private async void OnHardClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new MyQuizPage()); // Placeholder action for Hard button
        }
    }
}
