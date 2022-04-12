package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateUserRequest;
import com.team4.deskbookingappbe.model.domain.TEMPUser;
import com.team4.deskbookingappbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TEMPUser createUser(CreateUserRequest request) {
        TEMPUser user = TEMPUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        PasswordEncryptionService encryptionService = new PasswordEncryptionService();
        String encryptedPassword = encryptionService.passwordEncryption(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }
}
