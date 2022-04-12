package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.TEMPUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TEMPUser,Long> {

    Optional<TEMPUser> findUserByEmail(String email);

}
