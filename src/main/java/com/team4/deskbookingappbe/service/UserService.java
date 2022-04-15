package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateUserRequest;
import com.team4.deskbookingappbe.model.domain.DtoUser;
import com.team4.deskbookingappbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public DtoUser createUser(CreateUserRequest request) {
        DtoUser user = DtoUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(bcryptEncoder.encode(request.getPassword()))
                .build();

        return userRepository.save(user);
    }
    public List<DtoUser> fetchUsers(String email) {
        if(email != null)
        {
            return userRepository.findAllByEmail(email);
        }
        else
        {
            return userRepository.findAll();
        }
    }
}
