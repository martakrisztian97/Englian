package model;

/**
 * Felhasználó tárolására szolgáló osztály.
 * @author Márta Krisztián
 * @since 2023-03-04
 */
public class Felhasznalo {
    private int id;
    private String email;
    private String felhasznalonev;
    private String jelszo;

    public Felhasznalo() {}

    public Felhasznalo(int id, String email, String felhasznalonev, String jelszo) {
        this.id = id;
        this.email = email;
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public String getJelszo() {
        return jelszo;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" + "id=" + id + ", email=" + email + ", felhasznalonev=" + felhasznalonev + ", jelszo=" + jelszo + '}';
    }
}
