import { UserService } from './service/UserService.js';
import { WeatherService} from "./service/WeatherService.js";

const userService = new UserService();
const weatherService = new WeatherService();

//Roept de WeatherService aan om via de api data te krijgen over het weer en zet de tempmax in het veld in de agenda.
function getTemp() {
    let temp;
    weatherService.getWeatherData()
        .then(data => {
            console.log(data);
             temp = data['days']['0']['tempmax'];
            document.getElementById('temp').innerText= temp + '°C';
        })
}

// roept de login functie aan in Userservice waarin de backend wordt aangeroepen en een jwt token returned
// Hierna wordt de jwt token opgeslagen in localStorage en user wordt doorverwezen naar de homepage.html
function login() {
    userService.login().then((myJson) => {
        window.localStorage.setItem("myJWT", myJson.JWT);
        window.location.href = "../html/homepage.html"
    }) .catch((error) => console.log(error));
}

const loginForm = document.querySelector("#loginForm");
const loginButton = loginForm.querySelector("#loginButton");

// Click eventListener op login button
loginButton.addEventListener("click", login);

//Temperatuur wordt opgehaald via deze functie.
getTemp();



