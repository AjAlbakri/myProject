using Microsoft.Maui.Controls;
using System;

namespace Teachings
{
    public partial class HomePage : ContentPage
    {
        public HomePage()
        {
            InitializeComponent();
        }

        private async void OnLearningLanguageClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new TestKnowledgePage());
        }

        private async void OnGeneralQuizzesClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Story());
        }
    }
}
