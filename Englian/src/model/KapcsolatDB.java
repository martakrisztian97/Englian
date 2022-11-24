package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public static void main(String[] args) {
        System.out.println();
    }
}
