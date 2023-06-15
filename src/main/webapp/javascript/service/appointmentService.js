export class AppointmentService {

    //Roept de backend aan met een post method met daarbij de body van het form op de html
    // Hierbij wordt een afspraak opgeslagen in de backend
    createAppointment() {
        let formData = new FormData(document.querySelector("#appointmentForm"));
        let jsonRequestBody = {}
        formData.forEach((key, value) => jsonRequestBody[value] = key);
        console.log(jsonRequestBody);
        console.log("----");
        return fetch("http://localhost:8080/restservices/appointment", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
            body: JSON.stringify(jsonRequestBody)})
            .then((response) => {
                if (response.ok) {
                    return response;
                } else return response;
            })
            .catch((error) => console.log(error)) ;
    }

    loadAppointments() {
        return fetch("http://localhost:8080/restservices/appointment", {
            method: "GET",
            headers: {
                'Authorization': 'Bearer ' + window.localStorage.getItem("myJWT")
            }
        } )
            .then((response) => {
                if (response.ok) {
                    console.log(response);
                    return response;
                } else throw "Something went wrong!"
            })
            .catch((error) => console.log(error));

    }
}