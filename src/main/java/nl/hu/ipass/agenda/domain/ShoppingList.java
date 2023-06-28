package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingList implements Serializable {
    private List<ShoppingsItem> items = new ArrayList<>();

    public ShoppingList() {

    }

    public ShoppingList(List<ShoppingsItem> shoppingsItems) {
        this.items = shoppingsItems;
    }

    public void setItems(List<ShoppingsItem> shoppingsItems) {
        this.items = items;
    }

    //haalt alle items uit de shoppinglist
    public void clearShoppingList() {
        items = new ArrayList<>();
    }

    public List<ShoppingsItem> getItems() {
        return items;
    }
    public void addItem(ShoppingsItem shoppingsItem) {
        items.add(shoppingsItem);
    }


}
