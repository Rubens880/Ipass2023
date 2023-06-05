

export class UserService {

    constructor() {
    }

    login() {
        let formData = new FormData(document.querySelector("#loginForm"));
        let jsonRequestBody = {}
        formData.forEach((key, value) => jsonRequestBody[value] = key);
         return fetch("http://localhost:8080/restservices/authentication", {method: "POST",
            headers: {
                'Content-Type': 'application/json'},
            body: JSON.stringify(jsonRequestBody)})
            .then(function (response) {
                if (response.ok) return response.json();
                else throw "Wrong username/password";
            })
            .catch(error => console.log(error));


    }





}