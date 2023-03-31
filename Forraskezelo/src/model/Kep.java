package model;

/**
 * Kép adatainak tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2023-03-31
 */
public class Kep {
    private String megnevezes;
    private String forras;

    public Kep(String megnevezes, String forras) {
        this.megnevezes = megnevezes;
        this.forras = forras;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public String getForras() {
        return forras;
    }

    @Override
    public String toString() {
        return "Kep{" + "megnevezes=" + megnevezes + ", forras=" + forras + '}';
    }
}