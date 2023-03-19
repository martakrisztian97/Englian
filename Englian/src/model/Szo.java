package model;

/**
 * Szó tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class Szo {
    private int id;
    private String angol;
    private String magyar;
    private String kep;

    public Szo(int id, String angol, String magyar, String kep) {
        this.id = id;
        this.angol = angol;
        this.magyar = magyar;
        this.kep = kep;
    }

    public String getAngol() {
        return angol;
    }

    public String getMagyar() {
        return magyar;
    }

    public String getKep() {
        return kep;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Szo{" + "id=" + id + ", angol=" + angol + ", magyar=" + magyar + ", kep=" + kep + '}';
    }
}