from flask import Flask
from flask import jsonify

app = Flask(__name__)

users = {
        'name' : 'Bob',
        'age' : 50
}

@app.route("/")
def index():
    return jsonify( users )
