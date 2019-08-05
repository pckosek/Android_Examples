from flask import Flask
from flask import jsonify
from flask import request
import sys

app = Flask(__name__)

users = [
    {
        'name' : 'Bob',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_1.jpg"
    },
    {
        'name' : 'Mary',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_2.jpg"
    },
    {
        'name' : 'Gene',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_3.jpg"
    },
    {
        'name' : 'Reggie',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_4.jpg"
    },
    {
        'name' : 'Erin',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_5.jpg"
    },
    {
        'name' : 'Odin',
        'photoUrl' : "https://user.tjhsst.edu/pckosek/static/images/user_6.jpg"
    },
]

@app.route("/")
def index():
    num_users = request.args.get('count', default = 1, type = int)
    return jsonify( users[:num_users] )
