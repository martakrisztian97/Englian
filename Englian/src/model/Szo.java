package model;

/**
 * Szó tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class Szo {
    private String angol;
    private String magyar;
    private String kep;

    public Szo(String angol, String magyar, String kep) {
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

    @Override
    public String toString() {
        return "Szo{" + "angol=" + angol + ", magyar=" + magyar + ", kep=" + kep + '}';
    }
}
