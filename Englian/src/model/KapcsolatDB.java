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
     * A regisztrált felhasználók email címeinek lekérdezése.
     * @return A regisztrált felhasználók email címeit tartalmazó listával.
     */
    public ArrayList<String> emailCimeketLekerdez() {
        String query = "SELECT email FROM felhasznalok";
        ArrayList<String> lista = new ArrayList();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                String email = result.getString("email");
                lista.add(email);
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
     */ // @todo
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
     * A felhasználóhoz tartozó szószedetek témaköreinek lekérdezése.
     * @param f A felhasználó.
     * @return A témakörök adatait tartalmazó listával.
     */
    public ArrayList<Temakor> temakorokLekerdez(Felhasznalo f) {
        String query = "SELECT temakorok.id, temakorok.megnevezes, temakorok.kep, temakorok.mappa FROM temakorok, tananyag "
                + "WHERE tananyag.temakor_id = temakorok.id AND tananyag.felhasznalo_id = "+f.getId();
        ArrayList<Temakor> lista = new ArrayList<>();
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
                lista.add(new Temakor(id, megnevezes, kep, mappa));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: "+ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Egy adott témakör szavainak lekérdezése.
     * @param temakorId A témakör azonosítója.
     * @return A szavakat tartalmazó listával.
     */
    public ArrayList<Szo> szavakAdottTemakorbenLekerdez(int temakorId) {
        String query = "SELECT angol, magyar FROM szavak WHERE temakor_id = "+temakorId;
        ArrayList<Szo> lista = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                String angol = result.getString("angol");
                String magyar = result.getString("magyar");
                lista.add(new Szo(angol, magyar));
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