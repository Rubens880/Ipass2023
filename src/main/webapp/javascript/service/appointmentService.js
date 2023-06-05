export class AppointmentService {

    //Roept de backend aan met een post method met daarbij de body van het form op de html
    // Hierbij wordt een afspraak opgeslagen in de backend
    createAppointment() {
        let formData = new FormData(document.querySelector("#appointmentForm"));
        let jsonRequestBody = {}
        formData.forEach((key, value) => jsonRequestBody[value] = key);
        console.log(jsonRequestBody);
        return fetch("http://localhost:8080/restservices/appointment", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
            body: JSON.stringify(jsonRequestBody)})
            .then((response) => {
                if (response.ok) {
                    return response;
                } else throw "Something went wrong!"
            })
            .catch((error) => console.log(error)) ;
    }
}