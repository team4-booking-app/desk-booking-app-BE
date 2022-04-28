package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.model.domain.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<DtoReservations, Long> {
    List<DtoReservations> findAllByReservationId(Long reservationId);

    List<DtoReservations> findAllByDeskId(Long deskId);

    List<DtoReservations> findAllByUserEmail(String userEmail);

    @Query(value = "SELECT * FROM RESERVATIONS " +
            "WHERE (" +
            "(CAST(:reservationStart AS timestamp without time zone) BETWEEN reservation_start AND reservation_end)" +
            "OR" +
            "(CAST(:reservationEnd AS timestamp without time zone) BETWEEN reservation_start AND reservation_end)" +
            ")" +
            "OR" +
            "(" +
            "(reservation_start BETWEEN CAST(:reservationStart AS timestamp without time zone) AND CAST(:reservationEnd AS timestamp without time zone))" +
            "OR" +
            "(reservation_end BETWEEN CAST(:reservationStart AS timestamp without time zone) AND CAST(:reservationEnd AS timestamp without time zone))" +
            ")",
            nativeQuery = true)
    List<DtoReservations> findAllByReservationStartAndReservationEndWhereIntersectsBetween(String reservationStart, String reservationEnd);


}
