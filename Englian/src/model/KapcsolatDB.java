package model;

import java.sql.*;

/**
 * Regisztráció
 *
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

    public void regisztracio(String nev, String email, String felhasznalonev, String jelszo) {
        String query = "INSERT INTO felhasznalok (id, nev, email, felhasznalonev, jelszo)"
                + "VALUES (NULL, '" + nev + "', '" + email + "', '" + felhasznalonev + "', '" + jelszo + "')";
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

    /*public int sorokSzama() {
        String query = "SELECT nev, felhasznalonev, jelszo FROM felhasznalok";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host + dbName, userName, password);
            Statement st = (Statement) conn.createStatement();
            ResultSet result = st.executeQuery(query);
            int sorok = result.getInt();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
        return ;
    }*/
}