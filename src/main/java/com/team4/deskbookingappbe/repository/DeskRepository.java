package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.dtoDESK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<dtoDESK,Long> {
}
