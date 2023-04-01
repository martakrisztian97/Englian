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
     * @param rendezve A témakörök adatait tartalmazó lista legyen-e sorbarendezve a megnevezése alapján. (ABC sorrend)
     * @return A témakörök adatait tartalmazó listával.
     */
    public ArrayList<Temakor> temakorokLekerdez(Felhasznalo f, boolean rendezve) {
        String query = "SELECT temakorok.id, temakorok.megnevezes, temakorok.kep, temakorok.mappa, temakorok.beepitett FROM temakorok, tananyag "
                + "WHERE tananyag.temakor_id = temakorok.id AND tananyag.felhasznalo_id = " + f.getId();
        String queryRendezve = "SELECT temakorok.id, temakorok.megnevezes, temakorok.kep, temakorok.mappa, temakorok.beepitett FROM temakorok, tananyag "
                + "WHERE tananyag.temakor_id = temakorok.id AND tananyag.felhasznalo_id = " + f.getId() + " ORDER BY temakorok.megnevezes ASC";
        ArrayList<Temakor> lista = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result;
            if (rendezve) {
                result = st.executeQuery(queryRendezve);
            } else {
                result = st.executeQuery(query);
            }
            while (result.next()) {
                int id = result.getInt("id");
                String megnevezes = result.getString("megnevezes");
                String kep = result.getString("kep");
                String mappa = result.getString("mappa");
                boolean beepitett = result.getBoolean("beepitett");
                lista.add(new Temakor(id, megnevezes, kep, mappa, beepitett));
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
        String query = "SELECT id, angol, magyar, kep FROM szavak WHERE temakor_id = "+temakorId;
        ArrayList<Szo> lista = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String angol = result.getString("angol");
                String magyar = result.getString("magyar");
                String kep = result.getString("kep");
                lista.add(new Szo(id, angol, magyar, kep));
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
     * Egy tesztfeladatsor eredményének mentése adatbázisba.
     * @param felhasznaloId A felhasználó azonosítója.
     * @param temakorId A témakör azonosítója.
     * @param eredmeny Az eredmény.
     */
    public void tesztEredmenyFeltolt(int felhasznaloId, int temakorId, int eredmeny) {
        String query = "INSERT INTO eredmenyek (id, felhasznalo_id, temakor_id, eredmeny)"
                + "VALUES (NULL, '" + felhasznaloId + "', '" + temakorId + "', '" + eredmeny + "')";
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
     * Eredmények lekérdezése.
     * @param temakorId  A témakör azonosítója.
     * @return Az eredményeket tartalmazó listával.
     */
    public ArrayList<Eredmeny> eredmenyeketLekerdez(int temakorId) {
        String query = "SELECT felhasznalonev, eredmeny FROM felhasznalok, eredmenyek "
        +"WHERE eredmenyek.felhasznalo_id = felhasznalok.id AND eredmenyek.temakor_id = "+temakorId+" ORDER BY eredmeny DESC";
        ArrayList<Eredmeny> lista = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                String felhasznalonev = result.getString("felhasznalonev");
                int eredmeny = result.getInt("eredmeny");
                lista.add(new Eredmeny(felhasznalonev, eredmeny));
            }
        } catch (SQLException e) {
            System.out.println("Hiba: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: "+ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Szó törlése.
     * @param szoId A szó azonosítója.
     */
    public void szoTorles(int szoId) {
        String query = "DELETE FROM szavak WHERE szavak.id = " + szoId;
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
     * Szó módosítása.
     * @param szoId  A szó azonosítója.
     * @param angolModositas A módosított angol szó.
     * @param magyarModositas  A módosított magyar szó.
     */
    public void szotModosit(int szoId, String angolModositas, String magyarModositas) {
        String query = "UPDATE szavak SET angol = '"+angolModositas+"' WHERE szavak.id = " + szoId;
        String query2 = "UPDATE szavak SET magyar = '"+magyarModositas+"' WHERE szavak.id = " + szoId;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
    }
    
    /**
     * Új témakör létrehozása, valamint a témakör kapcsolásáa a felhasználóhoz.
     * @param felhasznaloId A felhasználó azonosítója.
     * @param megnevezes Az új témakör megnevezése.
     */
    public void ujTemakor(int felhasznaloId, String megnevezes) {
        String query = "INSERT INTO temakorok (id, megnevezes, kep, mappa, beepitett)"
                + "VALUES (NULL, '" + megnevezes + "', 'proba.png', '', 0)";
        String query2 = "INSERT INTO tananyag(id, felhasznalo_id, temakor_id) VALUES"
                + "(NULL, " + felhasznaloId + ", (SELECT temakorok.id FROM temakorok WHERE temakorok.megnevezes LIKE '"+ megnevezes +"') )";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
    }
    
    /**
     * Új szó feltöltése.
     * @param temakorId  A témakör azonosítója.
     * @param angol Az új szó angolul.
     * @param magyar Az új szó magyarul.
     */
    public void ujSzo(int temakorId, String angol, String magyar) {
        String query = "INSERT INTO szavak (id, temakor_id, angol, magyar, kep)"
                + "VALUES (NULL, '" + temakorId + "', '" + angol + "', '" + magyar + "', 'proba.png')";
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
     * Szószedet törlése.
     * @param temakorId A témakör azonosítója.
     */
    public void szoszedetTorlese(int temakorId) {
        String query = "DELETE FROM temakorok WHERE temakorok.id = " + temakorId;
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
}