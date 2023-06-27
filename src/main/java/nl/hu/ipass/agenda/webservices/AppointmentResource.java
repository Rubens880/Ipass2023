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
import java.text.ParseException;
import java.time.LocalDate;

@Path("appointment")
public class AppointmentResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response createAppointment(String requestBody) throws ParseException {
        JsonReader jsonReader = Json.createReader(new StringReader(requestBody));
        JsonObject jsonObject = jsonReader.readObject();
        String appointmentTitle = jsonObject.getString("title");
        String appointmentDescription = jsonObject.getString("description");
        String appointmentLocation = jsonObject.getString("location");
        String appoinmentDate1 = jsonObject.getString("date");
        LocalDate localDate = LocalDate.parse(appoinmentDate1);


        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        //Controle of startTijd voor eindTijd ligt


        Appointment appointment = new Appointment(appointmentTitle,localDate,startTime, endTime,appointmentDescription,appointmentLocation);
        Response response = Agenda.getAgenda().addAppointment(appointment);

        return response;
    }


    //Vraag alle afspraken op van de Agenda
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Path("all")
    public Response getAllAppointments() {
        return Response.ok(Agenda.getAgenda().getAppointments()).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getAppointmentById(@PathParam("id")Long id) {
        Appointment appointment = Agenda.getAgenda().getAppointmentById(id);

        if (appointment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(appointment).build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    @RolesAllowed("user")
    public Response updateAppointment(@PathParam("id") Long id, String requestBody) {
        JsonReader jsonReader = Json.createReader(new StringReader(requestBody));
        JsonObject jsonObject = jsonReader.readObject();
        String appointmentTitle = jsonObject.getString("title");
        String appointmentDescription = jsonObject.getString("description");
        String appointmentLocation = jsonObject.getString("location");
        String appoinmentDate1 = jsonObject.getString("date");
        LocalDate localDate = LocalDate.parse(appoinmentDate1);


        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        Appointment appointment = new Appointment(id, appointmentTitle,localDate,startTime,endTime,appointmentDescription,appointmentLocation);

        Appointment appointmentNew = Agenda.getAgenda().updateAppointment(appointment, id);

        if (appointmentNew == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        return Response.ok(appointmentNew).build();


    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    @RolesAllowed("user")
    public Response deleteAppointment(@PathParam("id") Long id) {
        System.out.println(id);
        Appointment appointment = Agenda.getAgenda().deleteAppointment(id);
        if (appointment == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        return Response.ok(appointment).build();
    }

}
