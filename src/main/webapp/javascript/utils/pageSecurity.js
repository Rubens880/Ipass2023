
// Functie die controleerd of de gebruiker een jwt token bezit. Hierdoor kan de gebruiker niet zomaar naar een pagina
// die niet voor hem bestemd is.
function checkIfLoggedIn() {
    console.log("functie werkt!")

        if (window.localStorage.getItem("myJWT") === null) {
            location.replace("http://localhost:8080/html/loginpage.html");
        }
}