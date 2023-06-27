export class AppointmentService {

    //Roept de backend aan met een post method met daarbij de body van het form op de html
    // Hierbij wordt een afspraak opgeslagen in de backend
    createAppointment() {
        let formData = new FormData(document.querySelector("#appointmentForm"));
        let jsonRequestBody = {}
        formData.forEach((key, value) => jsonRequestBody[value] = key);
        console.log(jsonRequestBody);
        console.log("----");
        return fetch("/restservices/appointment", {
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
    // Alle appointments wordt opgehaald via een get method.

    loadAppointments() {
        return fetch("/restservices/appointment/all", {
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

    //Update de appointment
    updateAppointment(id) {
        let formData = document.querySelector("#appointment-Dialog-Form");
        let jsonRequestBody = {};
        jsonRequestBody["title"] = formData.querySelector("#dialog-Name").value;
        jsonRequestBody["description"] = formData.querySelector("#dialog-Descriptie").value;
        jsonRequestBody["location"] = formData.querySelector("#dialog-Locatie").value;
        jsonRequestBody["date"] = formData.querySelector("#dialog-Datum").value;
        jsonRequestBody["startTime"] = formData.querySelector("#dialog-StartTime").value;
        jsonRequestBody["endTime"] = formData.querySelector("#dialog-EndTime").value;

        console.log(jsonRequestBody);
        console.log("----");

        return fetch( `/restservices/appointment/update/${id}`, {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
            body: JSON.stringify(jsonRequestBody)})
            .then((response) => {
                if (response.ok) {
                    return response;
                } else return response;
            })
            .catch((error) => console.log(error))



    }

    //delete appointment
    deleteAppointment(id){
        return fetch( `/restservices/appointment/delete/${id}`, {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")}
            })
            .then((response) => {
                if (response.ok) {
                    console.log(response);
                    return response;
                } else return response;
            })
            .catch((error) => console.log(error))


    }
}