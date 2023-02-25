package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Adatbázis kapcsolatért felelős osztály
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

    public void kapcsolodas() {
        this.host = "jdbc:mysql://localhost:3306/";
        this.dbName = "englian";
        this.driver = "com.mysql.jdbc.Driver";
        this.userName = "root";
        this.password = "";
    }

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

    public ArrayList<String> felhasznalok() {
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
}