package nl.hu.ipass.agenda.webservices;


import nl.hu.ipass.agenda.domain.Agenda;
import nl.hu.ipass.agenda.domain.Appointment;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("appointment")
public class AppointmentResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response createAppointment(String requestBody) {
        JsonReader jsonReader = Json.createReader(new StringReader(requestBody));
        JsonObject jsonObject = jsonReader.readObject();
        String appointmentTitle = jsonObject.getString("title");
        String appointmentDescription = jsonObject.getString("description");
        String appointmentLocation = jsonObject.getString("location");
        //Moet nog gefixt worden!
//        String appoinmentDate = jsonObject.getString("date");
//        String startTime = jsonObject.getString("startTime");
//        String endTime = jsonObject.getString("endTime");

        Appointment appointment = new Appointment(appointmentTitle,null,null,appointmentDescription,appointmentLocation);
        Agenda.getAgenda().addAppointment(appointment);

        return Response.ok().build();
    }


    //Vraag alle afspraken op van de Agenda
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response getAllAppointments() {
        return Response.ok(Agenda.getAgenda().getAppointments()).build();
    }
}
