package Classes;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class User {
    private final String nume;
    private final String prenume;
    private final int varsta;
    private PriorityQueue<Curs> cursuri = new PriorityQueue<>(Comparator.comparing(Curs::getNume));

    public User(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public PriorityQueue<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(PriorityQueue<Curs> cursuri) {
        this.cursuri = cursuri;
    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", cursuri=" + cursuri +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return varsta == user.varsta && nume.equals(user.nume) && prenume.equals(user.prenume) && Objects.equals(cursuri, user.cursuri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, varsta);
    }
}
