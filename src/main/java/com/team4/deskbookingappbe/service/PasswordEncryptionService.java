package com.team4.deskbookingappbe.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptionService {
    public String passwordEncryption(String rawPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
//        System.out.println(rawPassword + " : " + encodedPassword);
        return encodedPassword;
    }
}
