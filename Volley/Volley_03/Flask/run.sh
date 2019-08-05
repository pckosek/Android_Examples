#!/bin/bash
../venv/bin/gunicorn server:app -b 127.0.0.1:$PORT -w=1 --capture-output