using Microsoft.Maui.Controls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Teachings
{
    public partial class WelcomePage : ContentPage
    {
        private int currentQuestionIndex = 0;
        private readonly List<string> responses = new List<string>();
        private readonly List<string> questions = new List<string>
        {
            "What type of quizzes do you enjoy more: Story-based or Language Learning?",
            "How much time can you dedicate to studying daily?",
            "What subjects interest you the most?",
            "What language are you interested in learning?"
        };

        public WelcomePage()
        {
            InitializeComponent();
            AskQuestion();
        }

        private async void AskQuestion()
        {
            // Clear the previous question
            QuestionsStack.Children.Clear();

            if (currentQuestionIndex < 4) // Asks only 4 questions
            {
                var questionLabel = new Label
                {
                    Text = questions[currentQuestionIndex],
                    HorizontalOptions = LayoutOptions.Center,
                    Margin = new Thickness(0, 20),
                    Opacity = 0
                };

                var answerEntry = new Entry
                {
                    Placeholder = "Type your answer here...",
                    Margin = new Thickness(0, 20),
                    Opacity = 0
                };

                var nextButton = new Button
                {
                    Text = "Next",
                    Opacity = 0,
                    Command = new Command(async () =>
                    {
                        if (!string.IsNullOrWhiteSpace(answerEntry.Text))
                        {
                            // Error handling for numeric input
                            if (currentQuestionIndex == 1 && !IsNumeric(answerEntry.Text))
                            {
                                await DisplayAlert("Error", "Please enter a valid number.", "OK");
                                return;
                            }

                            // Error handling for text input
                            if (currentQuestionIndex == 0 || currentQuestionIndex == 2 || currentQuestionIndex == 3)
                            {
                                if (!IsText(answerEntry.Text))
                                {
                                    await DisplayAlert("Error", "Please enter text only.", "OK");
                                    return;
                                }
                            }

                            responses.Add(answerEntry.Text);
                            currentQuestionIndex++;
                            AskQuestion();
                        }
                        else
                        {
                            await DisplayAlert("Error", "Please provide an answer.", "OK");
                        }
                    })
                };

                QuestionsStack.Children.Add(questionLabel);
                QuestionsStack.Children.Add(answerEntry);
                QuestionsStack.Children.Add(nextButton);

                // Animation
                await Task.WhenAll(
                    questionLabel.FadeTo(1, 700),
                    answerEntry.FadeTo(1, 700),
                    nextButton.FadeTo(1, 700)
                );
            }
            else
            {
                DetermineRecommendedQuiz();
            }
        }

        private void DetermineRecommendedQuiz()
        {
            // Response to the questions asked
            int storyAnswersCount = responses.Count(a => a.ToLower().Contains("story"));
            int languageAnswersCount = responses.Count(a => a.ToLower().Contains("language"));

            if (storyAnswersCount > languageAnswersCount)
            {
                // Recommend starting with story-based quizzes
                DisplayAlert("Recommendation", "Based on your answers, we recommend starting with story-based quizzes.", "OK");
            }
            else if (languageAnswersCount > storyAnswersCount)
            {
                // Recommend starting with language learning quizzes
                DisplayAlert("Recommendation", "Based on your answers, we recommend starting with language learning quizzes.", "OK");
            }
            else
            {
                // Recommend based on availability
                DisplayAlert("Recommendation", "You have no clear preference. Please choose the type of quiz you prefer.", "OK");
            }

            Navigation.PushAsync(new LoginPage());
        }

        // Helper method to check if the input is numeric
        private bool IsNumeric(string input)
        {
            return int.TryParse(input, out _);
        }

        // Helper method to check if the input is text
        private bool IsText(string input)
        {
            return !string.IsNullOrWhiteSpace(input) && input.All(char.IsLetter);
        }
    }
}
