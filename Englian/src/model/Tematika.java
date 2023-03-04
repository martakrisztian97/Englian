package model;

/**
 * Tematikák tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2023-03-04
 */
public class Tematika {
    private int id;
    private String megnevezes;
    private String kep;
    private String mappa;

    public Tematika(int id, String megnevezes, String kep, String mappa) {
        this.id = id;
        this.megnevezes = megnevezes;
        this.kep = kep;
        this.mappa = mappa;
    }

    public int getId() {
        return id;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public String getKep() {
        return kep;
    }

    public String getMappa() {
        return mappa;
    }
}
