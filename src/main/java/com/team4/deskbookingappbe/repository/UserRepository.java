package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<DtoUser,Long> {

    Optional<DtoUser> findUserByEmail(String email);
    List <DtoUser> findAllByEmail(String email);
}
