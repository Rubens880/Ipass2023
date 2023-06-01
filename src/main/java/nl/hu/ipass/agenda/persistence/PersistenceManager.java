package nl.hu.ipass.agenda.persistence;



import nl.hu.ipass.agenda.domain.Agenda;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersistenceManager {

    public static void loadWorldFromFIle() throws IOException, ClassNotFoundException {
        Path homeDirectory = Path.of("/home");
        Path worldStorage = Path.of("/home/agenda.obj");
        if (!Files.exists(worldStorage)) {
            return;
        }

        InputStream is = Files.newInputStream(worldStorage);
        ObjectInputStream ois = new ObjectInputStream(is);
        Agenda world = (Agenda) ois.readObject();
        Agenda.setMy_agenda(world);
        is.close();
        ois.close();

    }

    public static void saveWorldToFile() throws IOException {
        Path homeDirectory = Path.of("/home");
        if (!Files.exists(homeDirectory)) {
            Files.createDirectory(homeDirectory);
        }

        Agenda AgendaToSave = Agenda.getAgenda();
        Path agendaStorage = Path.of("/home/agenda.obj");

        OutputStream os = Files.newOutputStream(agendaStorage);

        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(AgendaToSave);

        os.close();
        oos.close();
    }

}
