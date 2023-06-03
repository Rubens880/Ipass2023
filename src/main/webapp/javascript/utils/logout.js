const logoutHref = document.querySelector("#logout");


//werkt nog niet
logoutHref.addEventListener("click", () => {
    window.localStorage.removeItem("myJWT");
})