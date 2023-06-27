import { ShoppingListService } from "./service/shoppingListService.js";


const shoppingListService = new ShoppingListService();
//Laad alle shoppinglist items in.
function load() {
    shoppingListService.getShoppingListItems()
        .then((response) => {
            if (response.ok) {
                response.json().then((data) => {
                    data.items.forEach((item) => {
                        const shoppingList = document.querySelector("#shoppingList");
                        let newItem = document.createElement("li");
                        newItem.innerHTML = item.name + ": " + item.amount;
                        shoppingList.appendChild(newItem);
                    });
                });
            }
        });
}

//Voegt item toe aan shoppinglist
function addItem() {
    if (document.querySelector("#name-Input").value === ""
        || document.querySelector("#amount-Input").value === "") {
        window.alert("Missing values inside form!")
        return;
    }

    shoppingListService.addShoppingListItem().then((response) => {
        if (response.ok){
            location.reload();
        }else {
            window.alert("Something went wrong!");
        }
    })
}

//Cleared the shoppinglist
function clearShoppingList() {

    shoppingListService.clearShoppingList().then((response) => {
        if (response === true) {
            location.reload();
        } else {
            window.alert("Something went Wrong!");
        }

    })


}


load();

//Add eventlistenertoButton
document.querySelector("#addItem-FormButton").addEventListener("click", addItem);
document.querySelector("#clearShoppingList-Button").addEventListener("click", clearShoppingList);