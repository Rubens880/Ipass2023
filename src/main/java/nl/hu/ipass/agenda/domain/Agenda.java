package nl.hu.ipass.agenda.domain;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private static Agenda my_agenda = new Agenda();
    private List<Appointment> appointments = new ArrayList<>();
    private List<ShoppingList> shoppingLists = new ArrayList<>();

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

    public Response addAppointment(Appointment appointment) {
        String startTime = appointment.getStartTime();
        String endTime = appointment.getEndTime();
        if (!LocalTime.parse(startTime).isBefore(LocalTime.parse(endTime))
                || appointment.getName().length() > 15
                || appointment.getDescription().length() > 50) {
            System.out.println(appointment);
            return Response.status(Response.Status.CONFLICT).build();
        }


        this.appointments.add(appointment);
        return Response.ok().build();
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
