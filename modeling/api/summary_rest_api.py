#!/usr/bin/env python3
#-*- coding:utf-8 -*-

from flask import Flask, make_response
from flask_restful import Resource, Api
from flask_restful import reqparse
import json


# usage
from pororo import Pororo
summary = Pororo(task = "summarization", model = "abstractive", lang = "ko")


app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False
api = Api(app)


class TextSummary(Resource):
    def post(self):
        try:
            # Input Data
            parser = reqparse.RequestParser()
            parser.add_argument('full_text', type=str)
            args = parser.parse_args()

            # Full Text
            _fullText = args['full_text']

            # Model Exec & Output Data
            result = json.dumps(summary(_fullText), ensure_ascii=False)
            res = make_response(result)
            return res

        except Exception as e:
            return {'error': str(e)}


api.add_resource(TextSummary, '/summary')

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port='8080')