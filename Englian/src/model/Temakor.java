package model;

/**
 * Témakör tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2023-03-04
 */
public class Temakor {
    private int id;
    private String megnevezes;
    private String kep;
    private String mappa;
    private boolean beepitett;

    public Temakor(int id, String megnevezes, String kep, String mappa, boolean beepitett) {
        this.id = id;
        this.megnevezes = megnevezes;
        this.kep = kep;
        this.mappa = mappa;
        this.beepitett = beepitett;
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
    
    public boolean isBeepitett() {
        return beepitett;
    }

    @Override
    public String toString() {
        return "Temakor{" + "id=" + id + ", megnevezes=" + megnevezes + ", kep=" + kep + ", mappa=" + mappa + ", beepitett=" + beepitett + '}';
    }
}