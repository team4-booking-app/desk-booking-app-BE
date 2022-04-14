package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DAUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<DAUser,Long> {

    Optional<DAUser> findUserByEmail(String email);
}
