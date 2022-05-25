package Classes;

import Enums.CursTypes;

public class CursInformatica extends Curs{
    private String limbaj;

    public String getLimbaj()
    {
        return this.limbaj;
    }

    public CursInformatica(String nume, String limbaj)
    {
        super(nume);
        this.limbaj = limbaj;
        this.tipCurs = CursTypes.CURS_INFO;
    }

    public CursInformatica(String nume)
    {
        super(nume);
        this.tipCurs = CursTypes.CURS_INFO;
    }

    @Override
    public String toString() {
        return "CursInformatica{" +
                "nume='" + nume + '\'' +
                ", tipCurs=" + tipCurs +
                ", limbaj='" + limbaj + '\'' +
                '}';
    }
}
