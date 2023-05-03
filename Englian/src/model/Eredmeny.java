package model;

/**
 * Eredmény tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2023-03-18
 */
public class Eredmeny {
    private String felhasznalonev;
    private int eredmeny;

    public Eredmeny(String felhasznalonev, int eredmeny) {
        this.felhasznalonev = felhasznalonev;
        this.eredmeny = eredmeny;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public int getEredmeny() {
        return eredmeny;
    }

    @Override
    public String toString() {
        return "Eredmeny{" + "felhasznalonev=" + felhasznalonev + ", eredmeny=" + eredmeny + '}';
    }
}
