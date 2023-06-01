package nl.hu.ipass.agenda.domain;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private String location;
    private Agenda agenda;

    public Appointment( String name, Date startDate, Date endDate, String description, String location) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.description = description;
    this.location = location;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", agenda=" + agenda +
                '}';
    }
}
