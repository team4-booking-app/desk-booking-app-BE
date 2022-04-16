package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.api.ReservationsResponse;
import com.team4.deskbookingappbe.service.ReservationsDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class ReservationsController {

    private final ReservationsDataService reservationsDataService;

    public ReservationsController(ReservationsDataService reservationsDataService) {
        this.reservationsDataService = reservationsDataService;
    }

    @PostMapping(path = "/reservations")
    @Operation(summary = "Create new reservation")
    public Long createDesk(@Validated @RequestBody CreateReservationsRequest request) {
        return reservationsDataService.createReservation(request).getReservationId();
    }

    @GetMapping(value = "/reservations")
    @Operation(summary = "Get all reservations list from database by reservation id, user email, desk id or reservations between start and end time")
    public List<ReservationsResponse> fetchReservations(@RequestParam(required = false) Long reservationId,
                                                        @RequestParam(required = false) String userEmail,
                                                        @RequestParam(required = false) Long deskId,
                                                        @RequestParam(required = false) Timestamp reservationStart,
                                                        @RequestParam(required = false) Timestamp reservationEnd) {
        List<ReservationsResponse> reservations = reservationsDataService.fetchReservations(reservationId, userEmail, deskId, reservationStart, reservationEnd).stream()
                    .map(reservation -> new ReservationsResponse(reservation.getReservationId(), reservation.getUserEmail(), reservation.getDeskId(), reservation.getReservationStart(), reservation.getReservationEnd()))
                    .collect(Collectors.toList());
        if(reservations.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reservation not found with requested id, email, desk id or reservations between start and end time"
            );
        }
        else {
            return reservations;
        }
    }

    @DeleteMapping(value = "/reservations")
    @Operation(summary = "Delete reservation from database")
    public ResponseEntity<Void> deleteReservation(@RequestParam(required = false) Long reservationId) {
        reservationsDataService.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }
}
