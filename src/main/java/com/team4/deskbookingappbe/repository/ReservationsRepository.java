package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<DtoReservations,Long> {
    List<DtoReservations> findAllByReservationId (Long reservationId);
    List<DtoReservations> findAllByUserEmail (String userEmail);
    List<DtoReservations> findAllByDeskId (Long deskId);
    List<DtoReservations> findAllByRoomId (Long roomId);

    @Query(value = "select * from RESERVATIONS " +
            "where CAST(:reservationStart as timestamp without time zone) between reservation_start and reservation_end " +
            "or CAST(:reservationEnd as timestamp without time zone) between reservation_start and reservation_end",
    nativeQuery = true)
    List<DtoReservations> findAllByReservationStartAndReservationEndWhereIntersectsBetween(String reservationStart, String reservationEnd);
}
