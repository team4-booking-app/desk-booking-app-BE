package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<DtoReservations,Long> {
    List<DtoReservations> findAllByReservationId (Long reservationId);
    List<DtoReservations> findAllByUserEmail (String userEmail);
    List<DtoReservations> findAllByDeskId (Long deskId);
    List<DtoReservations> findAllByReservationStartBetween(Timestamp reservationStart, Timestamp reservationEnd);
}
