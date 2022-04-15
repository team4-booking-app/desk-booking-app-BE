package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.api.ReservationsResponse;
import com.team4.deskbookingappbe.service.ReservationsDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Get all reservations list from database")
    public List<ReservationsResponse> fetchReservations(@RequestParam(required = false) Long id) {
        return reservationsDataService.fetchReservations(id).stream()
                .map(reservation -> new ReservationsResponse(reservation.getReservationId(), reservation.getUserEmail(), reservation.getDeskId(), reservation.getReservationStart(), reservation.getReservationEnd()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/reservations/{id}")
    @Operation(summary = "Delete reservation from database")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationsDataService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
