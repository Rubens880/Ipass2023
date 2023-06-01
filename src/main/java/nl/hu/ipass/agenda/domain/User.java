package nl.hu.ipass.agenda.domain;

public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    private Agenda agenda;

    public User(int id, String userName, String password, String email, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Agenda getAgenda() {
        return agenda;
    }
}
