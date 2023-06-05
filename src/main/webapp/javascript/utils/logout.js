const logoutHref = document.querySelector("#logout");


//Haalt  JWT token weg uit localstorage om uit te loggen.
logoutHref.addEventListener("click", () => {
    window.localStorage.removeItem("myJWT");
})