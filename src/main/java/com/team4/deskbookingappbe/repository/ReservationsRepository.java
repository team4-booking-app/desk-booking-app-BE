package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.dtoRESERVATIONS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<dtoRESERVATIONS,Long> {
}
