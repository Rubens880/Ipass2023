package nl.hu.ipass.agenda.domain;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Appointment implements Serializable {

    private Long id;
    private String name;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String description;
    private String location;

    public Appointment( String name, LocalDate date, String startTime, String endTime, String description, String location) {
        this.id = generateRandomId();
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.location = location;
    }

    public Appointment(Long id,String name, LocalDate date, String startTime, String endTime, String description, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    //generate randomId
    public static Long generateRandomId(){
        int timeAtThisMoment = Instant.now().getNano();
        double theId = (timeAtThisMoment * Math.random()) / Math.random();

        return Math.round(theId);
    }

    public Long getId() {
        return id;
    }


    public void updateAppointment(Appointment appointment) {
        this.name = appointment.getName();
        this.endTime = appointment.getEndTime();
        this.startTime = appointment.startTime;
        this.description = appointment.getDescription();
        this.date = appointment.getDate();
        this.location = appointment.getLocation();
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", date=" + date +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
