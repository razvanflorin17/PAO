package Classes;

import Enums.CursTypes;

import java.util.Objects;

public class Curs {
    protected String nume;
    protected CursTypes tipCurs;

    public String getNume() {
        return nume;
    }

    public Curs(String nume) {
        this.nume = nume;
    }

    public Curs(Curs curs) {
        this.nume = curs.nume;
        this.tipCurs = curs.tipCurs;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "nume='" + nume + '\'' +
                ", tipCurs=" + tipCurs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curs curs = (Curs) o;
        return nume.equals(curs.nume) && tipCurs == curs.tipCurs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, tipCurs);
    }
}
