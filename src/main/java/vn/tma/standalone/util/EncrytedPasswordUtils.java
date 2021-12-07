package vn.tma.standalone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "user";
        String encrytedPassword = encrytePassword(password);

        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
