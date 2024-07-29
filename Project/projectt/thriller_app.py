from flask import Flask, render_template, request, jsonify
import requests

app = Flask(__name__)


api_key = 'sk-proj-pY75CEzlMsLCqAlZp5MHT3BlbkFJjfpgk0qYN6vE5eCoitin'

@app.route("/")
def index():
    return render_template('thriller_index.html')

@app.route("/get", methods=["POST"])
def chat():
    user_input = request.json.get('msg')
    if user_input:
        try:
            if is_thriller_request(user_input):
                response = generate_romance_story(user_input)
            else:
                response = "Sorry, I only generate thriller stories."

            return jsonify({"response": response})
        except Exception as e:
            print("Error:", e)
            return jsonify({"response": fallback_response()})

    return jsonify({"error": "No input provided"})

def generate_romance_story(prompt):
    try:
        response = requests.post(
            "https://api.openai.com/v1/completions",
            headers={
                "Authorization": f"Bearer {api_key}",
                "Content-Type": "application/json"
            },
            json={
                "model": "text-davinci-003",
                "prompt": prompt,
                "max_tokens": 300,
                "temperature": 0.7,
                "stop": None
            }
        )

        data = response.json()
        if 'choices' in data and len(data['choices']) > 0:
            romance_story = data['choices'][0]['text'].strip()
        else:
            romance_story = "No response received from OpenAI"

        return romance_story
    except Exception as e:
        print("Error:", e)
        return fallback_response()
def is_thriller_request(user_input):
    thriller_keywords = ['thriller', 'suspense', 'mystery', 'crime', 'detective', 'plot', 'suspenseful', 'tension', 'action']
    user_input_lower = user_input.lower()
    return any(keyword in user_input_lower for keyword in thriller_keywords)

def fallback_response():
    return "I'm sorry, I didn't understand that. Can you please rephrase or ask something else?"

if __name__ == "__main__":
    app.run(debug=True)
