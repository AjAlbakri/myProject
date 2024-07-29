using Microsoft.Maui.Controls;
using TextToSpeech = Xamarin.Essentials.TextToSpeech;

namespace Teachings
{
    public partial class Story : ContentPage
    {
        public string StoryText { get; }

        public Story()
        {
            // Set the long story text
            StoryText = @"Once upon a time, in a faraway kingdom, there lived a young prince named Eric. He was kind, brave, and loved by all in the kingdom. 
            One day, while exploring the forest near the castle, Eric stumbled upon a hidden cave. Curiosity getting the better of him, he ventured inside. 
            Deep within the cave, he found a mysterious golden key. Little did Eric know, this key would unlock a magical door to another world.As Eric held the golden key in his hand, he felt a strange energy emanating from it. Without hesitation, he approached a nearby door, hidden behind thick vines and moss. With a trembling hand, he inserted the key into the lock and turned it.

To his amazement, the door swung open silently, revealing a shimmering portal pulsating with otherworldly light. Without a second thought, Eric stepped through the threshold and found himself in a land unlike any he had ever seen.

Before him stretched a sprawling landscape of vibrant colors and strange creatures. The air was thick with magic, and the very ground beneath his feet seemed to hum with power.

Determined to uncover the secrets of this new realm, Eric embarked on a grand adventure, facing challenges and making allies along the way. With each step, he grew stronger and wiser, unlocking the true potential within himself.

And so, the young prince's journey had only just begun, as he delved deeper into the mysteries of the enchanted world beyond the magical door.";

            InitializeComponent();

            BindingContext = this;
        }

        private async void OnAnswerQuestionsClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new StoryPage());
        }

        private async void OnToggleReaderClicked(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            string buttonText = button.Text;

            if (buttonText == "▶ Play Story")
            {
                
                await TextToSpeech.SpeakAsync(StoryText);
                button.Text = "❚❚ Pause Story";
            }
            else
            {
               
                await TextToSpeech.SpeakAsync("");
                button.Text = "▶ Play Story";
            }
        }

   
        private async void OnPauseClicked(object sender, EventArgs e)
        {
            
        }
    }
}

