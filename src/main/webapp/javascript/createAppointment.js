const appointmentButton = document.querySelector("#appointmentFormButton");


function createAppointment() {
    console.log("nu afspraakaanmaken");
    let formData = new FormData(document.querySelector("#appointmentForm"));
    let jsonRequestBody = {}
    formData.forEach((key, value) => jsonRequestBody[value] = key);
    console.log(jsonRequestBody);
    fetch("http://localhost:8080/restservices/appointment", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
        body: JSON.stringify(jsonRequestBody)})
        .then((response) => {
            if (response.ok) {

                return response.json();
            } else throw "Something went wrong!"
        })
        .catch((error) => console.log(error)) ;
}








appointmentButton.addEventListener("click", createAppointment);