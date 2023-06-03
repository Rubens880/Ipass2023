async function getWeatherData() {
    return await fetch("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Nederland?unitGroup=metric&key=CBKGAU4AHNRFLCVPSBDHX5ZPG&contentType=json", {
        "method": "GET",
        "headers": {
        }});

}
async function getTemp() {
    let response = await getWeatherData();
    let data = await response.json();
    console.log(data);
    let temp = data['days']['0']['tempmax'];
    document.getElementById('temp').innerText= temp + '°C';
    return temp;
}

function login() {
    console.log("nu login")
    let formData = new FormData(document.querySelector("#loginForm"));
    let jsonRequestBody = {}
    formData.forEach((key, value) => jsonRequestBody[value] = key);
    console.log(jsonRequestBody);
    fetch("http://localhost:8080/restservices/authentication", {method: "POST",
        headers: {
            'Content-Type': 'application/json'},
        body: JSON.stringify(jsonRequestBody)})
        .then(function (response) {
            console.log(response)
            if (response.ok) return response.json();
            else throw "Wrong username/password";
        })
        .then(myJson => {
            window.localStorage.setItem("myJWT", myJson.JWT);
            window.location.href = "../html/homepage.html"

        })
        .catch(error => console.log(error));

}

getTemp();

const loginForm = document.querySelector("#loginForm");
const loginButton = loginForm.querySelector("#loginButton");
loginButton.addEventListener("click", login);



