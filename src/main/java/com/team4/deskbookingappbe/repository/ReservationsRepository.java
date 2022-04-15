package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoReservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<DtoReservations,Long> {
}
