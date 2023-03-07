package model;

/**
 * Szó tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class Szo {
    private String angol;
    private String magyar;

    public Szo(String angol, String magyar) {
        this.angol = angol;
        this.magyar = magyar;
    }

    public String getAngol() {
        return angol;
    }

    public String getMagyar() {
        return magyar;
    }

    @Override
    public String toString() {
        return "Szo{" + "angol=" + angol + ", magyar=" + magyar + '}';
    }
}
