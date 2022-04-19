package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.api.ReservationsResponse;
import com.team4.deskbookingappbe.service.ReservationsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @PostMapping(path = "/reservations")
    @Operation(summary = "Create new reservation")
    public Long createReservation(@Validated @RequestBody CreateReservationsRequest request) {
        return reservationsService.createReservation(request).getReservationId();
    }

    @GetMapping(value = "/reservations")
    @Operation(summary = "Get all reservations list from database by reservation id, user email, desk id or reservations between start and end time")
    public List<ReservationsResponse> fetchReservations(@RequestParam(required = false) Long reservationId,
                                                        @RequestParam(required = false) String userEmail,
                                                        @RequestParam(required = false) Long deskId,
                                                        @RequestParam(required = false) String reservationStart,
                                                        @RequestParam(required = false) String reservationEnd) {
        List<ReservationsResponse> reservations = reservationsService.fetchReservations(reservationId, userEmail, deskId, reservationStart, reservationEnd).stream()
                    .map(reservation -> new ReservationsResponse(reservation.getReservationId(), reservation.getUserEmail(), reservation.getDeskId(), reservation.getReservationStart().toString().substring(0,19), reservation.getReservationEnd().toString().substring(0,19)))
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

    @DeleteMapping(value = "/reservations/{reservationId}")
    @Operation(summary = "Delete reservation from database")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservationsService.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }
}
