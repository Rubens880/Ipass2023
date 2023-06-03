
function checkIfLoggedIn() {
    console.log("functie werkt!")

    if (window.localStorage.getItem("myJWT") === null) {
        location.replace("http://localhost:8080/html/loginpage.html");
    }


}




