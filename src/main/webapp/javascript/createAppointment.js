import { AppointmentService} from "./service/appointmentService.js";

const appointmentService = new AppointmentService()


// Appointment Service wordt aangeroepen en daarna wordt er op basis van de response een alert gegooid met succes of niet.
function createAppointment() {
    appointmentService.createAppointment()
        .then((response) => {
            if (response.ok) {
                window.alert("Succesvol opgeslagen!");
            } else {
                window.alert("Er is iets fout gegaan!")
            }

    });
}







const appointmentButton = document.querySelector("#appointmentFormButton");
appointmentButton.addEventListener("click", createAppointment);