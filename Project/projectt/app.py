
from flask import Flask, render_template, request, jsonify
import requests

app = Flask(__name__)


api_key = 'sk-proj-pY75CEzlMsLCqAlZp5MHT3BlbkFJjfpgk0qYN6vE5eCoitin'

@app.route("/")
def index():
    return render_template('index.html')

@app.route("/get", methods=["POST"])
def chat():
    user_input = request.json.get('msg')
    if user_input:
        try:
          
            response = requests.post(
                "https://api.openai.com/v1/completions",
                headers={
                    "Authorization": f"Bearer {api_key}",
                    "Content-Type": "application/json"
                },
                json={
                    "model": "gpt-3.5-turbo-instruct",
                    "prompt": user_input,
                    "max_tokens": 300,
                    "temperature": 0.7,
                    "stop": None
                }
            )

           
            print(response.json())

           
            data = response.json()
            if 'choices' in data and len(data['choices']) > 0:
                assistant_response = data['choices'][0]['text'].strip()
            else:
                assistant_response = "No response received from OpenAI"

            return jsonify({"response": assistant_response})
        except Exception as e:
          
            print("Error:", e)
            return jsonify({"response": fallback_response()})

    return jsonify({"error": "No input provided"})

def fallback_response():
    return "I'm sorry, I didn't understand that. Can you please rephrase or ask something else?"

@app.route("/about")
def about():
    return render_template('about.html')

@app.route("/settings")
def settings():
    return render_template('settings.html')




@app.route("/elderly")
def elderly():
    return render_template('elderly.html')




@app.route("/conversation")
def conversation():
    print("hello")
    genre = request.args.get('genre')
    if genre == 'romance':
        return render_template('romance.html', genre=genre)
    elif genre == 'thriller':
        return render_template('thriller.html', genre=genre)
    elif genre == 'fantasy':
        return render_template('fantasy.html', genre=genre)
   
    else:
        return "Invalid genre"










if __name__ == "__main__":
    app.run(debug=True)































# from flask import Flask, render_template, request, jsonify
# from transformers import AutoModelForCausalLM, AutoTokenizer
# import random
# import openai

# app = Flask(__name__)

# # Initialize the model and tokenizer
# tokenizer = AutoTokenizer.from_pretrained("microsoft/DialoGPT-large")
# model = AutoModelForCausalLM.from_pretrained("microsoft/DialoGPT-large")



# # Set up your OpenAI API key
# openai.api_key = '  k-proj-SNzGRO7oBuQCNAIeALTuT3BlbkFJZJ2SC646lwtq4fSVMlQW'

# conversation_history = []
# conversation_context = ""  # Store the conversation context as a string

# # Different story segments
# stories = [
#     "Once upon a time, in a land far away, there lived a brave knight.",
#     "Long ago, in a mystical forest, there was a hidden treasure waiting to be discovered.",
#     "In the heart of the city, there was a magical shop where wishes came true.",
#     "Deep beneath the ocean waves, there was a kingdom of mermaids and sea creatures.",
#     "Among the stars, there was a spaceship on a quest to explore new galaxies.",
#     "In a small village, there was a young girl with a secret power waiting to be unleashed.",
#     "High up in the mountains, there was a monastery where monks practiced ancient rituals.",
#     "In the depths of the jungle, there was a lost temple guarded by ancient spirits.",
#     "On a remote island, there was a tribe with a special connection to nature.",
#     "In a bustling city, there was a detective solving mysteries with wit and cunning.",
#     "In a magical land, there was a princess trapped in a tower, waiting for her prince.",
#     "In a far-off kingdom, there was a dragon terrorizing the villagers until a hero appeared.",
#     "In a futuristic world, there was a scientist on a mission to save humanity.",
#     "In the realm of dreams, there was a doorway to other dimensions waiting to be opened.",
#     "In the land of giants, there was a tiny creature with a big heart on a quest for adventure."
# ]


# def generate_response(user_input):
#     global conversation_context, conversation_history

#     # Add the user input to the conversation history
#     conversation_history.append(user_input)

#     # Generate the response using the model
#     input_text = f"{conversation_context} {user_input}".strip()
#     input_ids = tokenizer.encode(input_text, return_tensors='pt')
#     output = model.generate(input_ids, max_length=150, pad_token_id=tokenizer.eos_token_id, num_return_sequences=1,
#                             do_sample=True)
#     generated_text = tokenizer.decode(output[0], skip_special_tokens=True)

#     # Update the conversation context for the next interaction
#     conversation_context += f" {user_input} {generated_text}"

#     # Append the generated response to the conversation history
#     conversation_history.append(generated_text)

#     return generated_text


# def generate_story():
#     global conversation_context, conversation_history

#     try:
#         generated_story = ""
#         story_index = random.randint(0, len(stories) - 1)
#         prompt = stories[story_index]

#         # Generate multiple story segments
#         for _ in range(5):  # Generate 5 story segments
#             input_ids = tokenizer.encode(prompt, return_tensors='pt')
#             output = model.generate(
#                 input_ids,
#                 max_length=800,  # Increase the max length for longer stories
#                 pad_token_id=tokenizer.eos_token_id,
#                 num_return_sequences=1,
#                 num_beams=5,  # Use beam search for better results
#                 temperature=0.7,
#                 do_sample=True,
#                 early_stopping=True
#             )
#             segment = tokenizer.decode(output[0], skip_special_tokens=True)

#             if not segment.endswith('.'):
#                 segment += '.'

#             generated_story += segment + " "

#         return generated_story.strip()
#     except Exception as e:
#         return str(e)


# # Define a fallback response function
# def fallback_response():
#     return "I'm sorry, I didn't understand that. Can you please rephrase or ask something else?"


# @app.route("/")
# def index():
#     return render_template('index.html')


# @app.route("/get", methods=["POST"])
# def chat():
#     global conversation_context, conversation_history

#     user_input = request.json.get('msg')
#     if user_input:
#         try:
#             if user_input.lower() == "story please":
#                 # Generate a story and update conversation context
#                 story = generate_story()
#                 conversation_history.append(story)
#                 conversation_context = ""  # Reset conversation context for new story
#                 return jsonify({"response": story, "conversation_history": conversation_history})
#             elif user_input.lower() == "more story please":
#                 # Generate additional story segments
#                 additional_story = generate_story()
#                 conversation_history.append(additional_story)
#                 return jsonify({"response": additional_story, "conversation_history": conversation_history})
#             else:
#                 # Generate a response to the user input
#                 response = generate_response(user_input)
#                 conversation_history.append(response)
#                 return jsonify({"response": response, "conversation_history": conversation_history})
#         except Exception as e:
#             # Fallback response in case of error
#             return jsonify({"response": fallback_response(), "conversation_history": conversation_history})

#     return jsonify({"error": "No input provided"})


# @app.route("/about")
# def about():
#     return render_template('about.html')


# @app.route("/settings")
# def settings():
#     return render_template('settings.html')


# if __name__ == "__main__":
#     app.run(debug=True)























