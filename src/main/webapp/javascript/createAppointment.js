import { AppointmentService} from "./service/appointmentService.js";

const appointmentService = new AppointmentService()


// Appointment Service wordt aangeroepen en daarna wordt er op basis van de response een alert gegooid met succes of niet.
function createAppointment() {
    appointmentService.createAppointment()
        .then((response) => {
            if (response.ok) {
                window.alert("Afspraak succesvol opgeslagen!");
                let allInputs = document.querySelectorAll("input");
                allInputs.forEach((input) => {input.value = '';})
                document.querySelector("textarea").value = '';
            } else {
                window.alert("Er is iets fout gegaan!")
            }

    });
}

//Functie createAppointment wordt toegevoegd aan event click op de appointmentButton in het formulier.
const appointmentButton = document.querySelector("#appointmentFormButton");
appointmentButton.addEventListener("click", createAppointment);