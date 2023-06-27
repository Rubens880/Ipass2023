//Hier wordt de agenda in aangemaakt.
import { AppointmentService} from "./service/appointmentService.js";

const appointmentService = new AppointmentService()

let id = '';

let appointments = [];
//Haalt op hoeveel dagen in die maand zitten
const daysInMonth = (year, month) => new Date(year, month, 0).getDate();
//Haalt op welke naam die bepaalde dag heeft
function getDayName(dayNumber) {
    let day;
    switch (dayNumber) {
        case 0:
            return day = "Zondag";
        case 1:
            return day = "Maandag";
        case 2:
            return day = "Dinsdag";
        case 3:
            return day = "Woensdag";
        case 4:
            return day = "Donderdag";
        case 5:
            return day = "Vrijdag";
        case 6:
            return day = "Zaterdag";
    }
}
//Haalt op welke maand naam het is.
function getMonthName(monthNumber) {
    let monthName;
    switch (monthNumber) {
        case 0:
            return monthName = "Januari";
        case 1:
            return monthName = "Februari";
        case 2:
            return monthName = "Maart";
        case 3:
            return monthName = "April";
        case 4:
            return monthName = "Mei";
        case 5:
            return monthName = "Juni";
        case 6:
            return monthName = "Juli";
        case 7:
            return monthName = "Augustus";
        case 8:
            return monthName = "September";
        case 9:
            return monthName = "Oktober";
        case 10:
            return monthName = "November";
        case 11:
            return monthName = "December";
    }
}
//haalt op welk maandNummer het is bij maandnaam
function getMonthNumberByName(monthName) {
    let monthNumber;
    switch (monthName) {
        case "Januari":
            return monthNumber = 1;
        case "Februari":
            return monthNumber = 2;
        case "Maart":
            return monthNumber = 3;
        case "April":
            return monthNumber = 4;
        case "Mei":
            return monthNumber = 5;
        case "Juni":
            return monthNumber = 6;
        case "Juli":
            return monthNumber = 7;
        case "Augustus":
            return monthNumber = 8;
        case "September":
            return monthNumber = 9;
        case "Oktober":
            return monthNumber = 10;
        case "November":
            return monthNumber = 11;
        case "December":
            return monthNumber = 12;
    }

}

//laad alle appointments in en zet default values
function load() {
    const date = new Date();
    document.querySelector("#selectedMonth").value = getMonthName(date.getMonth());
    document.querySelector("#selectedYear").value = date.getFullYear();

    appointmentService.loadAppointments()
        .then((response) => {
            return response.json();
        }).then((appointmentData) => {
            appointments.push(appointmentData);
            render();
    })
}
//render functie per agenda dag die gemaakt wordt en wordt ingevuld. Returned een element
function renderTemplate(dayNumber, dayName , year, month, appointments) {
    const template = document.querySelector("#day-Template");
    //console.log(appointments);
    let clone = template.content.cloneNode(true);
    clone.querySelector("#date-Template").innerText = dayName + " " + dayNumber;
    clone.querySelector(".day-Article").id = `${year}-${month}-${dayNumber}`

    appointments.sort((a, b) => {
        const startTimeA = new Date(`2000-01-01T${a.startTime}`).getTime();
        const startTimeB = new Date(`2000-01-01T${b.startTime}`).getTime();
        return startTimeA - startTimeB;
    });



    appointments.forEach((appointment) => {
        let newElement = document.createElement("li");
        newElement.innerText = `${appointment['startTime']}/${appointment['endTime']}: ${appointment['name']}`;
        newElement.setAttribute("data-json", JSON.stringify(appointment));
        clone.querySelector("#appointmentList").appendChild(newElement);
        newElement.addEventListener('click', renderAppointmentDialog);
    })
    return clone;
}
//Render functie die de agenda maakt met daarin de appointments en alles ingevuld
//Haalt ook oude agenda dagen eruit
function render() {
    let Articles = document.querySelector("#renderArticles");
    while (Articles.firstChild) {
        Articles.removeChild(Articles.firstChild);
    }


    let selectedMonth = getMonthNumberByName(document.querySelector("#selectedMonth").value);
    let selectedYear = parseInt(document.querySelector("#selectedYear").value);
    let amountOfDaysInMonth = daysInMonth(selectedYear, selectedMonth);
    for (let i = 1; i <= amountOfDaysInMonth; i++) {
        let dt = new Date(`${selectedMonth} ${i}, ${selectedYear}`);

        let appointmentsThatDay =[];
        appointments['0'].forEach((appointmentData) => {
            let appointmentDate = new Date(appointmentData['date']);

            if (dt.getDate() === appointmentDate.getDate()
                && dt.getFullYear() === appointmentDate.getFullYear()
                && dt.getMonth() === appointmentDate.getMonth()) {
                appointmentsThatDay.push(appointmentData);
            }
        })

        let clone = renderTemplate(i, getDayName(dt.getDay()), selectedYear, selectedMonth , appointmentsThatDay);
        Articles.appendChild(clone);
    }
}

//Render functie die het dialog opent met de appointment informatie.
function renderAppointmentDialog() {

    const dialog = document.querySelector("#appointment-Info-Dialog")

    if (dialog.style.display === "block") {
        dialog.style.display = "none";
        return;
    }
    dialog.style.display = "block";
    console.log(JSON.parse(this.getAttribute("data-json")));
    const dialogInfo = JSON.parse(this.getAttribute("data-json"));

    document.getElementById("dialog-id").textContent = dialogInfo.id;
    document.getElementById("dialog-Name").value = dialogInfo.name;
    document.getElementById("dialog-Descriptie").textContent = dialogInfo.description;
    document.getElementById("dialog-Locatie").value = dialogInfo.location;
    document.getElementById("dialog-Datum").value = dialogInfo.date;
    document.getElementById("dialog-StartTime").value = dialogInfo.startTime;
    document.getElementById("dialog-EndTime").value = dialogInfo.endTime;

    id = dialogInfo.id;
}

//Update appointment
function updateAppointment() {
    console.log(id);

    appointmentService.updateAppointment(id).then((response)=> {
        if (response.ok) {
            location.reload();
        } else {
            console.log("Something went wrong!")
            window.alert("Something went wrong!")
        }
        }
    )

}

//delete appointment
function deleteAppointment() {
    console.log(id);
    appointmentService.deleteAppointment(id).then((response) => {
        if (response.ok) {
            location.reload();
        } else {
            console.log("Something went wrong!")
            window.alert("Something went wrong!")
        }
    })

}

function downloadPDF() {
    print();
}

load();





//Eventlisteners
document.querySelector("#selectedMonth").addEventListener("change", render);
document.querySelector("#selectedYear").addEventListener("change", render);
document.querySelector("#dialog-CloseButton").addEventListener("click", renderAppointmentDialog);
document.querySelector("#dialog-Update-Dialog").addEventListener("click", updateAppointment);
document.querySelector("#dialog-DeleteButton").addEventListener("click", deleteAppointment);
document.querySelector("#download-PDF-button").addEventListener("click", downloadPDF);