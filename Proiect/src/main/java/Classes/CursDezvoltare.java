package Classes;

import Enums.CursTypes;

public class CursDezvoltare extends Curs{
    public String categorie;

    public CursDezvoltare(String nume, String categorie) {
        super(nume);
        this.categorie = categorie;
    }

    public CursDezvoltare(Curs curs, String categorie) {
        super(curs);
        this.categorie = categorie;
        this.tipCurs = CursTypes.CursDezvoltare;
    }

    public String getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "CursDezvoltare{" +
                "nume='" + nume + '\'' +
                ", tipCurs=" + tipCurs +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
