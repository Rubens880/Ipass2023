package nl.hu.ipass.agenda.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;


class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    public void beforeAll() {
        this.agenda = new Agenda();
    }

    @Test
    @DisplayName("Voeg appointment toe aan agenda")
    public void addAppointmentTest() {
        Appointment appointment = new Appointment("TestAppointment", null,"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        assertEquals(true, agenda.getAppointments().contains(appointment));

    }

    @Test
    @DisplayName("Voeg meerdere appointments toe en check lengte")
    public void appointmentsTestLength() {
        Appointment appointment = new Appointment("TestAppointment", null,"12:12","13:13","Test desc", "Tiel");
        Appointment appointment1 = new Appointment("TestAppointment", null,"12:12","13:13","Test desc", "Tiel");
        agenda.addAppointment(appointment);
        agenda.addAppointment(appointment1);
        assertEquals(2, agenda.getAppointments().size());
    }


    static Stream<Arguments> differentTimes() {
        return Stream.of(
                Arguments.of(
                        new Appointment("Test", null,"11:12","12:13","Test desc", "Tiel"),
                        1
                ),
                Arguments.of(
                        new Appointment("Test2", null,"12:12","11:13","Test desc", "Tiel"),
                        0
                )
        );


    }

    @ParameterizedTest
    @DisplayName("Voeg appointment toe met begintijd en eindtijd")
    @MethodSource("differentTimes")
    public void appointmentTimeTests(Appointment appointment, int expectedAppointmentListSize ) {
        agenda.addAppointment(appointment);

        assertEquals(expectedAppointmentListSize, agenda.getAppointments().size());
    }


    static Stream<Arguments> differentTitleLenght() {
        return Stream.of(
                Arguments.of(
                        new Appointment("Test", null,"11:12","12:13","Test desc", "Tiel"),
                        1
                ),
                Arguments.of(
                        new Appointment("DitZijn15Charss", null,"11:12","12:13","Test desc", "Tiel"),
                        1
                ),
                Arguments.of(
                        new Appointment("DitZijnMeerdan15Chars", null,"11:12","12:13","Test desc", "Tiel"),
                        0
                )
        );
    }
    @ParameterizedTest
    @DisplayName("Test Title length")
    @MethodSource("differentTitleLenght")
    public void appointmentTitleMaxCharsTest(Appointment appointment, int expectedAppointmentListSize) {
        agenda.addAppointment(appointment);
        assertEquals(expectedAppointmentListSize, agenda.getAppointments().size());

    }

    static Stream<Arguments> differentDescriptionLength() {
        return Stream.of(
                Arguments.of(
                        new Appointment("Test", null,"11:12","12:13","Test desc", "Tiel"),
                        1
                ),
                Arguments.of(
                        new Appointment("Test2", null,"11:12","12:13","Dit zijn in totaal 50 karakters dus zou goed zijn.", "Tiel"),
                        1
                ),
                Arguments.of(
                        new Appointment("Test3", null,"11:12","12:13","Dit zijn in totaal meer dan 50 karakters dus zou fout moeten zijn.", "Tiel"),
                        0
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Test Description length")
    @MethodSource("differentDescriptionLength")
    public void appointmentDiscriptionMaxCharsTest(Appointment appointment, int expectedAppointmentListSize) {
        agenda.addAppointment(appointment);
        assertEquals(expectedAppointmentListSize, agenda.getAppointments().size());

    }





}