from flask import Flask
from flask import jsonify

app = Flask(__name__)

users = [
    {
        'name' : 'Bob',
        'age' : 50
    },
    {
        'name' : 'Sue',
        'age' : 20
    },
    {
        'name' : 'Phil',
        'age' : 41
    },
    {
        'name' : 'Erin',
        'age' : 42
    },
    {
        'name' : 'Odin',
        'age' : 4
    }
    
]

@app.route("/")
def index():
    return jsonify( users )
