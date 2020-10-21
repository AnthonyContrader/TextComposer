package it.contrader.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Questa classe fornisce dei metodi utili per il controllo degli input
 */

public class SecurityController {

    public static String hashPassword(String plainPassword){
        if (plainPassword == null || plainPassword.isEmpty())
            return null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainPassword.getBytes(StandardCharsets.UTF_8));
            byte[] messageDigest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b: messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
