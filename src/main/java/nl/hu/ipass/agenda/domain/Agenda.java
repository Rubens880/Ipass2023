package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private static Agenda my_agenda = new Agenda();
    private List<Appointment> appointments = new ArrayList<>();
    private List<ShoppingList> shoppingLists = new ArrayList<>();

    //Concept word nog gebruikt.
    // Hashmap 1: 5 Jaar achteruit en 5 Jaar vooruit opslaan. / Hashmap2: String = Maanden van dat jaar + appointments die maand.
    //private HashMap<String,HashMap<String,List<Appointment>>> agendaMaanden;

    public Agenda(){
    }

    public static Agenda getAgenda() {
        return my_agenda;
    }

    public static void setMy_agenda(Agenda agenda) {
        my_agenda = agenda;
        my_agenda.appointments = agenda.getAppointments();
        my_agenda.shoppingLists = agenda.getShoppingLists();
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void addShoppingList(ShoppingList shoppingList) {
        this.shoppingLists.add(shoppingList);
    }



    @Override
    public String toString() {
        return "Agenda{" +
                ", Appointments=" + appointments +
                ", shoppingLists=" + shoppingLists +
                '}';
    }
}
