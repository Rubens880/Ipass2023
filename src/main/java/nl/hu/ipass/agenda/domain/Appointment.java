package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Appointment implements Serializable {
    private String name;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String description;
    private String location;

    public Appointment( String name, LocalDate date, String startTime, String endTime, String description, String location) {
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

//    public boolean checkStartBeforeEndTime(String startTime, String  endTime) {
//        return LocalTime.parse(startTime).isBefore(LocalTime.parse(endTime));
//    }

    @Override
    public String toString() {
        return "Appointment{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
