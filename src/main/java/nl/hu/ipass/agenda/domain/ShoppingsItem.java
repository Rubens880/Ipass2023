package nl.hu.ipass.agenda.domain;

import java.io.Serializable;

public class ShoppingsItem implements Serializable {
    private String name;
    private int amount;

    public ShoppingsItem(int id, String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
