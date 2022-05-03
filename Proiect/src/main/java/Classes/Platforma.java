package Classes;

import java.util.ArrayList;
import java.util.List;

public class Platforma {
    private final String nume;
    private final List<User> users;
    private final List<Profesor> profesori;
    private final List<Curs> cursuri;
    private final List<Meeting> meetings;

    public Platforma(String nume, List<User> users, List<Profesor> profesori, List<Curs> cursuri, List<Meeting> meetings) {
        this.nume = nume;
        this.users = users;
        this.profesori = profesori;
        this.cursuri = cursuri;
        this.meetings = meetings;
    }

    public String getNume() {
        return nume;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addProfesor(Profesor profesor) {
        profesori.add(profesor);
    }

    public void addCurs(Curs curs) {
        cursuri.add(curs);
    }

    @Override
    public String toString() {
        return "Platforma{" +
                "nume='" + nume + '\'' +
                ", users=" + users +
                ", profesori=" + profesori +
                ", cursuri=" + cursuri +
                '}';
    }
}
