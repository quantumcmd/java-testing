package resources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordUtils {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateSalt(){
        return generateSalt(8);
    }
    public static String generateSalt(int length){
        StringBuilder value = new StringBuilder(length);

        for(int i = 0; i < length; i++){
            value.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(value);
    }

    public static String generateSecurePassword(String password, String salt){
        return hashedPassword(password, salt);
    }

    public static String hashedPassword(String password, String salt){
        MessageDigest md;
        String result = "";
        try{
            md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            result = new String(md.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: Invalid Hash Algorithm");
            System.exit(1);
        }
        return result;
    }

    public static boolean verifyUserPassword(String passwordEntered, String userSalt, String securePassword){
        return securePassword.equals(hashedPassword(passwordEntered, userSalt));
    }
}
