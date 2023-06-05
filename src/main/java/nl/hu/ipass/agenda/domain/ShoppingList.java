package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ShoppingList implements Serializable {
    private String name;
    private Date date;
    private List<ShoppingsItem> Items;

    private Agenda agenda;

    public ShoppingList( String name, Date date, List<ShoppingsItem> shoppingsItems) {
        this.name = name;
        this.date = date;
        this.Items = shoppingsItems;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public List<ShoppingsItem> getItems() {
        return Items;
    }

    public Agenda getAgenda() {
        return agenda;
    }
}
