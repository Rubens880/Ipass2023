package nl.hu.ipass.setup;


import nl.hu.ipass.agenda.persistence.PersistenceManager;
import nl.hu.ipass.security.MyUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyServletContextListener implements ServletContextListener {


    //Functie die wordt aangeroepen bij starten van de applicatie
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing application");

        //Gebruiker wordt aangemaakt
        MyUser.createUser("Ruben", "123", "user");
        try {
            //Agenda wordt opgehaald uit het fileSysteem
            PersistenceManager.loadAgendaFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Functie die wordt aangeroepen bij het afsluiten van de applicatie
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Terminating application");
        try {
            //Agenda wordt opgeslagen
            PersistenceManager.saveAgendaToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
