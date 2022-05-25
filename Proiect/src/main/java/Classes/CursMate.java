package Classes;

import Enums.CursTypes;

public class CursMate extends Curs{
    private String categorie;

    public String getCategorie()
    {
        return this.categorie;
    }

    public CursMate(String nume, String categorie)
    {
        super(nume);
        this.categorie = categorie;
        this.tipCurs = CursTypes.CURS_MATE;
    }

    public CursMate(String nume)
    {
        super(nume);
        this.tipCurs = CursTypes.CURS_MATE;
    }

    @Override
    public String toString() {
        return "CursMate{" +
                "nume='" + nume + '\'' +
                ", tipCurs=" + tipCurs +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
