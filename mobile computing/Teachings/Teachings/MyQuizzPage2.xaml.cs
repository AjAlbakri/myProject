using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Maui.Controls;

namespace Teachings;

public partial class MyQuizzPage2 : ContentPage
{

    private List<QuestionModel> _questions = new List<QuestionModel>();
    private int _currentQuestionIndex = 0;



    public MyQuizzPage2()
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
    Question = "What did you do yesterday?",
    Answers = new List<string> { "ماذا فعلت يوم أمس؟", "ماذا فعلت يوم أمس؟", "ماذا فعلت يوم أمس؟", "ماذا فعلت يوم أمس؟" },
    CorrectAnswer = "ماذا فعلت يوم أمس؟"
},
new QuestionModel
{
    Question = "Where are you from?",
    Answers = new List<string> {"من أين أنت؟", "من أين أنت؟" , "من أين أنت؟", "من أين أنت؟" },
    CorrectAnswer = "من أين أنت؟"
},
new QuestionModel
{
    Question = "What's your favorite hobby?",
    Answers = new List<string> {  "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟" },
    CorrectAnswer = "ما هو هوايتك المفضلة؟"
},
new QuestionModel
{
    Question = "Have you ever been to Dubai?",
    Answers = new List<string> { "هل سبق لك أن زرت دبي؟", "هل سبق لك أن زرت دبي؟", "هل سبق لك أن زرت دبي؟", "هل سبق لك أن زرت دبي؟" },
    CorrectAnswer = "هل سبق لك أن زرت دبي؟"
},
new QuestionModel
{
    Question = "How was your weekend?",
    Answers = new List<string> {  "كيف كان عطلتك؟", "كيف كان عطلتك؟", "كيف كان عطلتك؟", "كيف كان عطلتك؟" },
    CorrectAnswer = "كيف كان عطلتك؟"
},
new QuestionModel
{
    Question = "What's your favorite hobby?",
    Answers = new List<string> { "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟", "ما هو هوايتك المفضلة؟" },
    CorrectAnswer = "ما هو هوايتك المفضلة؟"
},
new QuestionModel
{
    Question = "Who discovered Earth's gravity?",
    Answers = new List<string> { "من اكتشف الجاذبية الأرضية؟", "من اكتشف الجاذبية الأرضية؟", "من اكتشف الجاذبية الأرضية؟", "من اكتشف الجاذبية الأرضية؟" },
    CorrectAnswer = "من اكتشف الجاذبية الأرضية؟"
},
new QuestionModel
{
    Question = "What is the capital of the United States?",
    Answers = new List<string> {  "ما هي عاصمة الولايات المتحدة؟", "ما هي عاصمة الولايات المتحدة؟", "ما هي عاصمة الولايات المتحدة؟", "ما هي عاصمة الولايات المتحدة؟"},
    CorrectAnswer = "ما هي عاصمة الولايات المتحدة؟"
},
new QuestionModel
{
    Question = "Who painted the Mona Lisa?",
    Answers = new List<string> { "من رسم لوحة الموناليزا؟", "من رسم لوحة الموناليزا؟", "من رسم لوحة الموناليزا؟", "من رسم لوحة الموناليزا؟" },
    CorrectAnswer = "من رسم لوحة الموناليزا؟"
},
new QuestionModel
{
    Question = "How many days in a week?",
    Answers = new List<string> { "كم يومًا في الأسبوع؟", "كم يومًا في الأسبوع؟", "كم يومًا في الأسبوع؟", "كم يومًا في الأسبوع؟", "كم يومًا في الأسبوع؟" },
    CorrectAnswer = "كم يومًا في الأسبوع؟"
},



              
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
            // First wrong attempt
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

