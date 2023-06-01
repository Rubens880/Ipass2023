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

getTemp();

