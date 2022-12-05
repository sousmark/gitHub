const Vonage = require('@vonage/server-sdk');

const vonage = new Vonage({
  apiKey: "844b00e6",
  apiSecret: "KdjPk5xBPrGosTYG"
});

const from = "NTM Cyril"
const to = "336619172688"
const text = 'Cyril je te trouverais et je te tuerais !'

vonage.message.sendSms(from, to, text, (err, responseData) => {
    if (err) {
        console.log(err);
    } else {
        if(responseData.messages[0]['status'] === "0") {
            console.log("Message sent successfully.");
        } else {
            console.log(`Message failed with error: ${responseData.messages[0]['error-text']}`);
        }
    }
});