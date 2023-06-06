package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private String name;
    private Date date;
    private String startTime;
    private String endTime;
    private String description;
    private String location;

    public Appointment( String name, Date date, String startTime, String endTime, String description, String location) {
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

    public Date getDate() {
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
