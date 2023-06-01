package nl.hu.ipass.setup;


import nl.hu.ipass.agenda.persistence.PersistenceManager;
import nl.hu.ipass.security.MyUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing application");

        MyUser.createUser("Ruben", "123", "user");
        try {
            PersistenceManager.loadWorldFromFIle();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Terminating application");
        try {
            PersistenceManager.saveWorldToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
