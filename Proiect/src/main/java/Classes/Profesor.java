package Classes;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Profesor {
    private final String nume;
    private final String prenume;
    private final int varsta;
    private final int rating;
    private PriorityQueue<Curs> cursuri = new PriorityQueue<>(Comparator.comparing(Curs::getNume));

    public Profesor(String nume) {
        this.nume = nume;
        this.prenume = null;
        this.varsta = 0;
        this.rating = 0;
    }

    public Profesor(String nume, String prenume, int varsta, int rating) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public PriorityQueue<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(PriorityQueue<Curs> cursuri) {
        this.cursuri = cursuri;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", rating=" + rating +
                ", cursuri=" + cursuri +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return varsta == profesor.varsta && rating == profesor.rating && nume.equals(profesor.nume) && prenume.equals(profesor.prenume) && cursuri.equals(profesor.cursuri);
    }
}
