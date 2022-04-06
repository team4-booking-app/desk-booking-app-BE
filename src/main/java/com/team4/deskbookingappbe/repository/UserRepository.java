package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
