package nl.hu.ipass.agenda.webservices;

import nl.hu.ipass.agenda.domain.Agenda;
import nl.hu.ipass.agenda.domain.ShoppingsItem;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("shoppinglist")
public class ShoppingListResource {

    //haal alle items uit shoppinglist op
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response getShoppingList() {

        return Response.ok(Agenda.getAgenda().getShoppingList()).build();
    }

    //addShoppingList item
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response addShoppingListItem(ShoppingItemDTO shoppingItemDTO) {
        ShoppingsItem shoppingsItem = new ShoppingsItem(shoppingItemDTO.name, shoppingItemDTO.amount);
        Agenda.getAgenda().addShopplingListItem(shoppingsItem);
        return Response.ok(Agenda.getAgenda().getShoppingList()).build();
    }


    private static class ShoppingItemDTO{
        public String name;
        public int amount;

    }

    //Verwijderd alle shoppingslist items
    @PATCH
    @RolesAllowed("user")
    public Response clearShoppingList() {
        Agenda.getAgenda().getShoppingList().clearShoppingList();
        return Response.ok().build();
    }

}
