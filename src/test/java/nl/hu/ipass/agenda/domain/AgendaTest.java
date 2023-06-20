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
        Appointment appointment = new Appointment("Test Appointment", null,"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        assertEquals(true, agenda.getAppointments().contains(appointment));

    }

    @Test
    @DisplayName("Voeg meerdere appointments toe en check lengte")
    public void appointmentsTestLength() {
        Appointment appointment = new Appointment("Test Appointment", null,"12:12","13:13","Test desc", "Tiel");
        Appointment appointment1 = new Appointment("Test Appointment", null,"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        agenda.addAppointment(appointment1);
        assertEquals(2, agenda.getAppointments().size());
    }

    @Test
    @DisplayName("Voeg appointment toe met eindtijd voor begintijd")
    public void appointmentTimeTestFalse() {
        Appointment appointment = new Appointment("Test Appointment", null,"12:12","11:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);

        assertEquals(0, agenda.getAppointments().size());
    }

    @Test
    @DisplayName("Voeg appointment toe met begintijd voor eindtijd")
    public void appointmentTimeTestGood() {
        Appointment appointment = new Appointment("Test Appointment", null,"11:12","12:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);

        assertEquals(1, agenda.getAppointments().size());
    }




}