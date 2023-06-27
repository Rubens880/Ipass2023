export class ShoppingListService {

//Haalt alle shoppinglist items op uit de backend.
    getShoppingListItems() {
        const options = {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
        }

        return fetch('/restservices/shoppinglist', options).then((response) => {
            if (response.ok) {
                return response;
            } else {
                console.log("Something went wrong!")
            }
        })
        
    }

    //Stuurt data naar backend met nieuwe shoppinglist item
    addShoppingListItem() {
        let formData = new FormData(document.querySelector("#shoppingListForm"));
        let jsonRequestBody = {}
        formData.forEach((key, value) => jsonRequestBody[value] = key);

        const options = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
            body: JSON.stringify(jsonRequestBody)
        }
        return fetch('/restservices/shoppinglist', options).then((response) => {
            if (response.ok) {
                return response;
            } else {
                console.log("Something went wrong!")
            }
        })

    }

    //clearShoppingList items
    clearShoppingList() {


        const options = {
            method: "PATCH",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' +  window.localStorage.getItem("myJWT")},
        }

        return fetch("/restservices/shoppinglist", options)
            .then((response) => {
                if (response.ok) {
                    return true;
                } else {
                     console.log("Something went wrong!")
                }
            })


    }




}
