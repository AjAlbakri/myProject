
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Maui.Controls;


namespace Teachings
{
    public partial class MyQuizPage : ContentPage
    {
        private List<QuestionModel> _questions = new List<QuestionModel>();
        private int _currentQuestionIndex = 0;

        public MyQuizPage()
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
            Question = "املأ الفراغ: التفاح والبرتقال والموز هي أنواع مختلفة من الـ ____________.",
            CorrectAnswer = "فواكه",
            Choices = new List<string> { "خضراوات", "حبوب", "فواكه", "لحوم" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الجهاز الذي يستخدم لتحويل الطاقة الكهربائية إلى طاقة حركية هو المحرك الـ ____________.",
            CorrectAnswer = "الكهربائي",
            Choices = new List<string> { "الشمسي", "الكهربائي", "الحراري", "البخاري" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الكتابة بواسطة الضغط على أزرار تسمى الـ ____________.",
            CorrectAnswer = "طباعة",
            Choices = new List<string> { "خط", "كتابة", "طباعة", "تأليف" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الحاسوب الذي يعمل بمساعدة البطارية يسمى الحاسوب الـ ____________.",
            CorrectAnswer = "المحمول",
            Choices = new List<string> { "المكتبي", "الشخصي", "المحمول", "العملاق" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الجهاز الذي يستخدم لقياس درجة الحرارة يسمى الـ ____________.",
            CorrectAnswer = "ميزان الحرارة",
            Choices = new List<string> { "ساعة", "مقياس", "قمر", "ميزان الحرارة" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: العملية التي تقوم بتحويل الماء إلى بخار باستخدام الحرارة تسمى الـ ____________.",
            CorrectAnswer = "تبخير",
            Choices = new List<string> { "تبثيت", "تسخين", "تبخير", "تجميد" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الجهاز الذي يستخدم لتخزين المعلومات والبيانات بشكل دائم يسمى الـ ____________.",
            CorrectAnswer = "قرص صلب",
            Choices = new List<string> { "ذاكرة وصول عشوائي", "قرص مضغوط", "محرك أقراص", "قرص صلب" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الشكل الهندسي الذي يحتوي على ستة أضلاع هو الـ ____________.",
            CorrectAnswer = "مكعب",
            Choices = new List<string> { "مثلث", "دائرة", "مستطيل", "مكعب" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: الجزء الخارجي للأرض يسمى الـ ____________.",
            CorrectAnswer = "قشرة",
            Choices = new List<string> { "نواة", "قشرة", "صخرة", "باطن" }
        },
        new QuestionModel
        {
            Question = "املأ الفراغ: المادة التي توجد في الهواء وتسبب الحرائق تسمى الـ ____________.",
            CorrectAnswer = "الأكسجين",
            Choices = new List<string> { "الأكسجين", "النتروجين", "الغاز", "البخار" }
        }
    });
        }











     



        private async void DisplayQuestion(int index)
        {
            if (index < _questions.Count)
            {
                QuestionModel question = _questions[index];
                QuestionLabel.Text = question.Question;

                var choices = question.Choices; 
                AnswerButton1.Text = choices[0];
                AnswerButton2.Text = choices[1];
                AnswerButton3.Text = choices[2];
                AnswerButton4.Text = choices[3];
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
            public string? SelectedAnswer { get; set; }
            public List<string> Choices { get; internal set; }
        }

    }
}
