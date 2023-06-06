package nl.hu.ipass.agenda.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;


class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    public void beforeAll() {
        this.agenda = new Agenda();
    }

    @Test
    @DisplayName("Voeg appointment toe aan agenda")
    public void addAppointmentTest() {
        Appointment appointment = new Appointment("Test Appointment",new Date(),"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        assertEquals(true, agenda.getAppointments().contains(appointment));

    }

    @Test
    @DisplayName("Voeg meerdere appointments toe en check lengte")
    public void appointmentsTestLength() {
        Appointment appointment = new Appointment("Test Appointment",new Date(),"12:12","13:13","Test desc", "Tiel");
        Appointment appointment1 = new Appointment("Test Appointment",new Date(),"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        agenda.addAppointment(appointment1);
        assertEquals(2, agenda.getAppointments().size());
    }


}