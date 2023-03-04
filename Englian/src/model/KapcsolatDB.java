package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Adatbázis kapcsolatért felelős osztály.
 * @author Márta Krisztián
 * @since 2022-11-19
 */
public class KapcsolatDB {

    public String host;
    public String dbName;
    public String driver;
    public String userName;
    public String password;

    public KapcsolatDB() {
        kapcsolodas();
    }

    /**
     * Adatbázis kapcsolat létrehozása.
     */
    public void kapcsolodas() {
        host = "jdbc:mysql://localhost:3306/";
        dbName = "englian";
        driver = "com.mysql.jdbc.Driver";
        userName = "root";
        password = "";
    }
    
    /**
     * Regisztrált felhasználó adatainak mentése adatbázisba.
     * @param email A felhasználó email címe.
     * @param felhasznalonev A felhasználó felhasználóneve.
     * @param jelszo A felhasználó jelszava.
     */
    public void regisztracio(String email, String felhasznalonev, String jelszo) {
        String query = "INSERT INTO felhasznalok (id, email, felhasznalonev, jelszo)"
                + "VALUES (NULL, '" + email + "', '" + felhasznalonev + "', '" + jelszo + "')";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            st.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
    }

    /**
     * A regisztrált felhasználónevek lekérdezése.
     * @return A regisztrált felhasználóneveket tartalmazó listával.
     */
    public ArrayList<String> felhasznalonevekLekerdez() {
        String query = "SELECT felhasznalonev FROM felhasznalok";
        ArrayList<String> lista = new ArrayList();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                String felhasznalonev = result.getString("felhasznalonev");
                lista.add(felhasznalonev);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Egy adott felhasználó jelszavának lekérdezése a bejelentkezéshez.
     * @param felhasznalonev A felhasználó felhasználóneve.
     * @return A felhasználó jelszavával.
     */
    public String felhasznaloJelszava(String felhasznalonev) {
        String query = "SELECT jelszo FROM felhasznalok WHERE felhasznalonev LIKE \"" + felhasznalonev + "\"";
        String jelszo = "";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            result.next();
            jelszo = result.getString("jelszo");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
        return jelszo;
    }
    
    /**
     * Felhasználó adatainak lekérdezése felhasználónév alapján.
     * @param felhasznalonev A felhasználó felhasználóneve.
     * @return A felhasználó adatait tartalmazó Felhasználó típussal.
     */
    public Felhasznalo felhasznaloAdatokLekerdez(String felhasznalonev) {
        String query = "SELECT id, email, jelszo FROM felhasznalok WHERE felhasznalonev LIKE \"" + felhasznalonev + "\"";
        Felhasznalo felhasznalo = new Felhasznalo();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            result.next();
            int id = result.getInt("id");
            String email = result.getString("email");
            String jelszo = result.getString("jelszo");
            felhasznalo = new Felhasznalo(id, email, felhasznalonev, jelszo);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
        return felhasznalo;
    }
    
    /**
     * A tematikák lekérdezése.
     * @return A tematikák adatait tartalmazó listával.
     */
    public ArrayList<Tematika> tematikakLekerdez() {
        String query = "SELECT id, megnevezes, kep, mappa FROM tematikak";
        ArrayList<Tematika> lista = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String megnevezes = result.getString("megnevezes");
                String kep = result.getString("kep");
                String mappa = result.getString("mappa");
                lista.add(new Tematika(id, megnevezes, kep, mappa));
            }
        conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: "+ex.getMessage());
        }
        return lista;
    }
    
    
}