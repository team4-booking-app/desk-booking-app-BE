package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateUserRequest;
import com.team4.deskbookingappbe.model.domain.DtoUser;

import com.team4.deskbookingappbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<DtoUser> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            return new User(user.get().getEmail(),user.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with Email: " + email);
        }
    }

    public DtoUser save(CreateUserRequest request) {
        DtoUser user = DtoUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(bcryptEncoder.encode(request.getPassword()))
                .build();
        return userRepository.save(user);
    }

}