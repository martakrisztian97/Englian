package model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Állományműveletek végrehajtására szolgáló osztály.
 * @author Márta Krisztiám
 * @since 2023-03-31
 */
public class Allomanymuveletek {

    public static ArrayList<Kep> beolvas(String allomany) {
        ArrayList<Kep> lista = new ArrayList<>();
        RandomAccessFile beolvas;
        String sor;
        try {
            beolvas = new RandomAccessFile(allomany, "r");
            sor = beolvas.readLine();
            while (sor != null) {
                //sor = new String(sor.getBytes("ISO-8859-1"));
                lista.add(new Kep(sor.split(";")[0], sor.split(";")[1]));
                sor = beolvas.readLine();
            }
            beolvas.close();
        } catch (IOException e) {
            System.out.println("Hiba 1: " + e.getMessage());
        } catch (NumberFormatException n) {
            System.out.println("Hiba 2: " + n.getMessage());
        }
        return lista;
    }
}
