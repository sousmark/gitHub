from flask import Flask, render_template, jsonify

@app.route('/api/meteo/')
def meteo():
    dictionnaire = {
        'type': 'Prevision de temperature',
        'valeurs': [24, 24, 25, 26, 27, 28],
        'unite': "degres Celcius"
    }
    return jsonify(dictionnaire)