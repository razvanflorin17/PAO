package Classes;

import java.util.HashSet;
import java.util.Set;

public class Meeting {
    private final int ID;
    private final Profesor profesor;
    private final Set<User> users;
    private final Curs curs;
    private final int durata;

    public Meeting(int ID, Profesor profesor, Curs curs, int durata) {
        this.ID = ID;
        this.profesor = profesor;
        this.curs = curs;
        this.durata = durata;
        this.users = new HashSet<>();
    }

    public int getID() {
        return ID;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Curs getCurs() {
        return curs;
    }

    public int getDurata() {
        return durata;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "ID=" + ID +
                ", profesor=" + profesor +
                ", users=" + users +
                ", curs=" + curs +
                ", durata=" + durata +
                '}';
    }
}
