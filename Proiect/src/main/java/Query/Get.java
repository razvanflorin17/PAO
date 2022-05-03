package Query;

import Classes.*;

import java.util.List;

public class Get {
    public List<User> getUserByNume(Platforma platforma, String nume) {
        List<User> users = platforma.getUsers();
        return users.stream().filter(aux -> aux.getNume().equals(nume)).toList();
    }

    public List<User> getUserByPrenume(Platforma platforma, String prenume) {
        List<User> users = platforma.getUsers();
        return users.stream().filter(aux -> aux.getPrenume().equals(prenume)).toList();
    }

    public List<User> getUserByVarsta(Platforma platforma, int varsta) {
        List<User> users = platforma.getUsers();
        return users.stream().filter(aux -> aux.getVarsta() == varsta).toList();
    }

    public List<Profesor> getProfesorByNume(Platforma platforma, String nume) {
        List<Profesor> profesori = platforma.getProfesori();
        return profesori.stream().filter(aux -> aux.getNume().equals(nume)).toList();
    }

    public List<Profesor> getProfesorByPrenume(Platforma platforma, String prenume) {
        List<Profesor> profesori = platforma.getProfesori();
        return profesori.stream().filter(aux -> aux.getPrenume().equals(prenume)).toList();
    }

    public List<Profesor> getProfesorByVarsta(Platforma platforma, int varsta) {
        List<Profesor> profesori = platforma.getProfesori();
        return profesori.stream().filter(aux -> aux.getVarsta() == varsta).toList();
    }

    public List<Profesor> getProfesorByRating(Platforma platforma, int rating) {
        List<Profesor> profesori = platforma.getProfesori();
        return profesori.stream().filter(aux -> aux.getRating() == rating).toList();
    }

    public List<Meeting> getMeetingByProfesor(Platforma platforma, Profesor profesor) {
        List<Meeting> meetings = platforma.getMeetings();
        return meetings.stream().filter(aux -> aux.getProfesor().equals(profesor)).toList();
    }

    public List<Meeting> getMeetingByCurs(Platforma platforma, Curs curs) {
        List<Meeting> meetings = platforma.getMeetings();
        return meetings.stream().filter(aux -> aux.getCurs().equals(curs)).toList();
    }

    public List<Meeting> getMeetingByDurata(Platforma platforma, int durata) {
        List<Meeting> meetings = platforma.getMeetings();
        return meetings.stream().filter(aux -> aux.getDurata() == durata).toList();
    }
}
