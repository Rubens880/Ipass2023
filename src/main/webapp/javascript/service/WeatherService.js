export class WeatherService {
    constructor() {
    }
// Haalt data van het weer op via een api en returned de json hiervan.
    getWeatherData() {
        return fetch("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Nederland?unitGroup=metric&key=CBKGAU4AHNRFLCVPSBDHX5ZPG&contentType=json", {
            "method": "GET",})
            .then((response) => {
                console.log(response);
                if (response.ok) return response.json();
                else throw "something went wrong!";
            })
            .catch(error => console.log(error));

    }
}