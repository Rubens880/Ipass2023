package nl.hu.ipass.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //Bepaald welke packages Jersey inlaad.
        packages("nl.hu.ipass.agenda.webservices, nl.hu.ipass.security");
        register(RolesAllowedDynamicFeature.class);
    }
}

