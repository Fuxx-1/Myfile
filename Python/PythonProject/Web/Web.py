from flask import Flask
import json
from pojo.student import *

app = Flask(__name__)


@app.route('/')
def helloWorld():
    return json.dumps(student("rtrgad", 54, 25), default=student.direct2json)


if __name__ == '__main__':
    app.run()
