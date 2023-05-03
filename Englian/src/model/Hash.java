package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash-függvényekért felelős osztály.
 * @author Márta Krisztián
 * @since 2023-02-28
 */
public class Hash {
    
    /**
     * MD5 hash algoritmus implementálása.
     * @param jelszo A kódolni kívánt szöveg.
     * @return A kódolt szöveg.
     */
    public static String MD5(String jelszo) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(jelszo.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
