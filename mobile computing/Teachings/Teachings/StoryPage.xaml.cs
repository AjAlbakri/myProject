using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Maui.Controls;


namespace Teachings
{
    public partial class StoryPage : ContentPage

    {
        private List<QuestionModel> _questions = new List<QuestionModel>();
        private int _currentQuestionIndex = 0;
        private int _timeRemaining; // Time remaining for the current question
        private bool _isTimerRunning; // Flag to track if the timer is running
        private const int MaxTimePerQuestionInSeconds = 10; // Set the maximum time per question

        public StoryPage()
        {
            InitializeComponent();
            InitializeQuestions();
            DisplayQuestion(_currentQuestionIndex);
            StartTimer();
        }

        private void InitializeQuestions()
        {
            _questions.AddRange(new List<QuestionModel>
    {
        new QuestionModel
        {
            Question = "What did Eric find in the hidden cave?",
            Answers = new List<string> { "A. A mysterious golden key", "B. A treasure chest", "C. A dragon", "D. A magical door" },
            CorrectAnswer = "A. A mysterious golden key"
        },
        new QuestionModel
        {
            Question = "Where did Eric find the hidden cave?",
            Answers = new List<string> { "A. In the forest near the castle", "B. In the mountains", "C. Under the sea", "D. In the desert" },
            CorrectAnswer = "A. In the forest near the castle"
        },
        new QuestionModel
        {
            Question = "What did the golden key unlock?",
            Answers = new List<string> { "A. A treasure chest", "B. A magical door", "C. A secret passage", "D. A dragon's lair" },
            CorrectAnswer = "B. A magical door"
        },
        new QuestionModel
        {
            Question = "What did Eric see when he stepped through the portal?",
            Answers = new List<string> { "A. A beautiful garden", "B. A dark forest", "C. A mysterious kingdom", "D. A vast ocean" },
            CorrectAnswer = "C. A mysterious kingdom"
        },
        new QuestionModel
        {
            Question = "What was unique about the landscape in the new realm?",
            Answers = new List<string> { "A. It was black and white", "B. It was filled with vibrant colors", "C. It was barren and lifeless", "D. It was covered in snow" },
            CorrectAnswer = "B. It was filled with vibrant colors"
        },
        new QuestionModel
        {
            Question = "What did Eric encounter in the enchanted world?",
            Answers = new List<string> { "A. Friendly creatures", "B. Angry giants", "C. Evil witches", "D. Talking trees" },
            CorrectAnswer = "A. Friendly creatures"
        },
        new QuestionModel
        {
            Question = "How did Eric grow during his adventure?",
            Answers = new List<string> { "A. He became weaker", "B. He became more foolish", "C. He became stronger and wiser", "D. He stayed the same" },
            CorrectAnswer = "C. He became stronger and wiser"
        },
        new QuestionModel
        {
            Question = "What was Eric's ultimate goal in the enchanted world?",
            Answers = new List<string> { "A. To find a way back home", "B. To become king", "C. To defeat the evil sorcerer", "D. To find a magical artifact" },
            CorrectAnswer = "A. To find a way back home"
        },
        new QuestionModel
        {
            Question = "What did Eric learn about himself during his journey?",
            Answers = new List<string> { "A. He was selfish", "B. He was a coward", "C. He was brave and capable", "D. He was powerless" },
            CorrectAnswer = "C. He was brave and capable"
        },
        new QuestionModel
        {
            Question = "What did Eric find at the end of his journey?",
            Answers = new List<string> { "A. A magical artifact", "B. The key to another door", "C. The way back home", "D. A talking tree" },
            CorrectAnswer = "C. The way back home"
        }
    });
        }






        private async void DisplayQuestion(int index)
        {
            if (index < _questions.Count)
            {
                QuestionModel question = _questions[index];
                QuestionLabel.Text = question.Question;

                // Set button texts accordingly
                var answers = question.Answers;
                AnswerButton1.Text = answers[0];
                AnswerButton2.Text = answers[1];
                AnswerButton3.Text = answers[2];
                AnswerButton4.Text = answers[3];
            }
            else
            {
                // this handles the quiz completion
                await DisplayCompletionAlert();
            }
        }

        private async Task DisplayCompletionAlert()
        {
            int score = 0;
            StringBuilder feedbackBuilder = new StringBuilder();

            for (int i = 0; i < _questions.Count; i++)
            {
                QuestionModel question = _questions[i];
                if (question.SelectedAnswer == question.CorrectAnswer)
                {
                    score++;
                }
                else
                {
                    feedbackBuilder.AppendLine($"Question {i + 1}: {question.Question}");
                    feedbackBuilder.AppendLine($"Your answer: {question.SelectedAnswer}");
                    feedbackBuilder.AppendLine($"Correct answer: {question.CorrectAnswer}");
                    feedbackBuilder.AppendLine();
                }
            }

            string completionMessage = $"Quiz completed!\n\nYour score: {score}/{_questions.Count}\n\n";

            if (feedbackBuilder.Length > 0)
            {
                completionMessage += "Feedback on incorrect answers:\n\n" + feedbackBuilder.ToString();
            }
            else
            {
                completionMessage += "Congratulations! You answered all questions correctly.\n\n";
            }

            // Determine grading
            string grading = "";
            if (score >= 9)
            {
                grading = "Congrats you've nailed Distinction";
            }
            else if (score >= 7)
            {
                grading = "You have nailed Merit";
            }
            else if (score >= 5)
            {
                grading = "You've Passed";
            }
            else
            {
                grading = "Sorry, you've failed. Please retry again.";
            }

            completionMessage += $"\nYour grading: {grading}";

            // Add button options
            bool retakeQuiz = await DisplayAlert("Quiz Completed", completionMessage, "Retake Quiz", "End Quiz");

            if (retakeQuiz)
            {
                // Reset quiz
                _currentQuestionIndex = 0;
                foreach (var question in _questions)
                {
                    question.SelectedAnswer = null;
                }
                DisplayQuestion(_currentQuestionIndex);
            }
            else
            {
                // Navigate back
                await Navigation.PopAsync();
            }
        }










        private async void OnAnswerSelected(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            string selectedAnswer = button.Text;

            QuestionModel currentQuestion = _questions[_currentQuestionIndex];
            currentQuestion.SelectedAnswer = selectedAnswer;

            if (selectedAnswer == currentQuestion.CorrectAnswer)
            {
                _currentQuestionIndex++;
                if (_currentQuestionIndex < _questions.Count)
                {
                    DisplayQuestion(_currentQuestionIndex);
                }
                else
                {
                    await DisplayCompletionAlert();
                }
            }
            else
            {
                // First wrong attempt
                Xamarin.Essentials.Vibration.Vibrate(TimeSpan.FromSeconds(1)); // Vibrate for 1 second
                bool retry = await DisplayAlert("Incorrect", "Oops! Your answer is incorrect. Would you like to try again?", "Try Again", "Next Question");

                if (retry)
                {
                    // Reset selected answer for retry
                    currentQuestion.SelectedAnswer = null;

                    // Redisplay the current question
                    DisplayQuestion(_currentQuestionIndex);
                }
                else
                {
                    // Proceed to the next question only if they didn't choose to retry
                    // and notify them if the answer is wrong after retrying
                    await DisplayAlert("Incorrect", "Sorry, your answer is still incorrect.", "OK");

                    // Proceed to the next question
                    _currentQuestionIndex++;
                    if (_currentQuestionIndex < _questions.Count)
                    {
                        DisplayQuestion(_currentQuestionIndex);
                    }
                    else
                    {
                        await DisplayCompletionAlert();
                    }
                }
            }
        }





        private void StartTimer()
        {
            _timeRemaining = MaxTimePerQuestionInSeconds;

            _isTimerRunning = true;
            Device.StartTimer(TimeSpan.FromSeconds(1), () =>
            {
                UpdateTimerDisplay();
                if (_timeRemaining <= 0)
                {
                    HandleTimeOut();
                    return false;
                }
                _timeRemaining--;
                return _isTimerRunning; // Continue the timer loop if _isTimerRunning is true
            });
        }

        private void UpdateTimerDisplay()
        {
            TimerLabel.Text = $"{_timeRemaining} seconds left";
        }

        private void HandleTimeOut()
        {
            _isTimerRunning = false;
            MoveToNextQuestion();
        }
        private void MoveToNextQuestion()
        {
            // Your logic to move to the next question, e.g., _currentQuestionIndex++;
            if (_currentQuestionIndex < _questions.Count)
            {
                DisplayQuestion(_currentQuestionIndex);
            }
            else
            {
                // Quiz completed
                DisplayCompletionAlert();
            }
        }












        public class QuestionModel
        {
            public string Question { get; set; }
            public List<string> Answers { get; set; } = new List<string>();
            public string CorrectAnswer { get; set; }
            public string? SelectedAnswer { get; set; }
        }
    }
}

