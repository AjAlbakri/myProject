
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Maui.Controls;


namespace Teachings
{
    public partial class EasyQuizess
        : ContentPage
    {
        private List<QuestionModel> _questions = new List<QuestionModel>();
        private int _currentQuestionIndex = 0;

        public EasyQuizess()
        {
            InitializeComponent();
            InitializeQuestions();
            DisplayQuestion(_currentQuestionIndex);
        }

        private void InitializeQuestions()
        {
            _questions.AddRange(new List<QuestionModel>
            {
                new QuestionModel
                {


                     Question = "Translate the following Arabic statement into English: 'ما هو الكلمة العربية للشمس؟'",
            Answers = new List<string> { "Moon", "Star", "Sun", "Sky" },
            CorrectAnswer = "Sun"
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'ما هو الكلمة العربية للقمر؟'",
            Answers = new List<string> { "Moon", "Star", "Sun", "Sky" },
            CorrectAnswer = "Moon"
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'ما هو الكلمة العربية للماء؟'",
            Answers = new List<string> { "Fire", "Water", "Earth", "Wind" },
            CorrectAnswer = "Water"
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'ما هو الكلمة العربية للسماء؟'",
            Answers = new List<string> { "Moon", "Star", "Sun", "Sky" },
            CorrectAnswer = "Sky"
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'ما هو الكلمة العربية للتلفزيون؟'",
            Answers = new List<string> { "Television", "Radio", "Newspaper", "Internet" },
            CorrectAnswer = "Television"
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'هذا المطعم لديه أفضل الطعام في المدينة.'",
            Answers = new List<string> { "This restaurant has the best food in town.", "She is going to visit her grandmother.", "He wants to buy a new car.", "They are studying for their exams." },
            CorrectAnswer = "This restaurant has the best food in town."
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'الساعة الآن تشير إلى الثامنة مساءً.'",
            Answers = new List<string> { "The time now is eight o'clock in the evening.", "She likes to swim in the pool.", "He is reading a book in the library.", "They are planning a trip to the mountains." },
            CorrectAnswer = "The time now is eight o'clock in the evening."
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'سافرت إلى باريس العام الماضي.'",
            Answers = new List<string> { "I traveled to Paris last year.", "He is going to buy some groceries.", "She needs to finish her homework.", "They are watching a movie at the cinema." },
            CorrectAnswer = "I traveled to Paris last year."
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'أريد أن أشتري هاتفًا جديدًا.'",
            Answers = new List<string> { "I want to buy a new phone.", "She enjoys playing the piano.", "He is studying for his driving test.", "They are waiting for the bus." },
            CorrectAnswer = "I want to buy a new phone."
        },
        new QuestionModel
        {
            Question = "Translate the following Arabic statement into English: 'سوف نحتفل بعيد ميلادي في الشهر القادم.'",
            Answers = new List<string> { "We will celebrate my birthday next month.", "She is going to the gym to exercise.", "He wants to become a professional photographer.", "They are planning a beach vacation." },
            CorrectAnswer = "We will celebrate my birthday next month."
        }
    });
        }











      



        private async void DisplayQuestion(int index)
        {
            if (index < _questions.Count)
            {
                QuestionModel question = _questions[index];
                QuestionLabel.Text = question.Question;

             
                var answers = question.Answers;
                AnswerButton1.Text = answers[0];
                AnswerButton2.Text = answers[1];
                AnswerButton3.Text = answers[2];
                AnswerButton4.Text = answers[3];
            }
            else
            {
             
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

        
            bool retakeQuiz = await DisplayAlert("Quiz Completed", completionMessage, "Retake Quiz", "End Quiz");

            if (retakeQuiz)
            {
           
                _currentQuestionIndex = 0;
                foreach (var question in _questions)
                {
                    question.SelectedAnswer = null;
                }
                DisplayQuestion(_currentQuestionIndex);
            }
            else
            {
              
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
               
                Xamarin.Essentials.Vibration.Vibrate(TimeSpan.FromSeconds(1)); // Vibrate for 1 second
                bool retry = await DisplayAlert("Incorrect", "Oops! Your answer is incorrect. Would you like to try again?", "Try Again", "Next Question");

                if (retry)
                {
                
                    currentQuestion.SelectedAnswer = null;

                    DisplayQuestion(_currentQuestionIndex);
                }
                else
                {
                   
                    await DisplayAlert("Incorrect", "Sorry, your answer is still incorrect.", "OK");

                  
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












        public class QuestionModel
        {
            public string Question { get; set; }
            public List<string> Answers { get; set; } = new List<string>();
            public string CorrectAnswer { get; set; }
            public string? SelectedAnswer { get; set; } // Marked as nullable
        }
    }
}
