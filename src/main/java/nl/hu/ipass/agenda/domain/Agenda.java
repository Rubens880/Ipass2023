package nl.hu.ipass.agenda.domain;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private static Agenda my_agenda = new Agenda();
    private List<Appointment> appointments = new ArrayList<>();
    private ShoppingList shoppingList = new ShoppingList();

    public Agenda(){
    }

    public static Agenda getAgenda() {
        return my_agenda;
    }

    public static void setMy_agenda(Agenda agenda) {
        my_agenda = agenda;
        my_agenda.appointments = agenda.getAppointments();
        my_agenda.shoppingList = agenda.getShoppingList();
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
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

    public Appointment getAppointmentById(Long id) {
        System.out.println(id);
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                System.out.println(appointment.getId());
                return appointment;
            }
        }

        return null;


    }

    //update bestaande appointment
    public Appointment updateAppointment(Appointment appointmentNew, Long id) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId().equals(id)) {

                appointment.updateAppointment(appointmentNew);
                appointments.set(i, appointment);

                return appointment;
            }
        }

        return null;



    }

    //Delete bestaande appointment
    public Appointment deleteAppointment(Long id) {
        System.out.println(id);


        Appointment appointment = my_agenda.getAppointmentById(id);
        System.out.println(appointment);
        System.out.println(appointments);
        System.out.println(appointments.contains(appointment));
        if (appointments.contains(appointment)) {
            appointments.remove(appointment);
            return appointment;
        }

        return null;
    }

    public ShoppingList addShopplingListItem(ShoppingsItem shoppingsItem) {
        this.shoppingList.addItem(shoppingsItem);
        return this.shoppingList;
    }


    @Override
    public String toString() {
        return "Agenda{" +
                ", Appointments=" + appointments +
                '}';
    }
}
