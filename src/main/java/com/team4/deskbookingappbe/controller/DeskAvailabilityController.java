package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.domain.DtoDesk;
import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.service.DeskService;
import com.team4.deskbookingappbe.service.ReservationsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/v1")
public class DeskAvailabilityController {

    private final ReservationsService reservationsService;
    private final DeskService deskService;

    public DeskAvailabilityController(ReservationsService reservationsService, DeskService deskService) {
        this.reservationsService = reservationsService;
        this.deskService = deskService;
    }

    @GetMapping(path = "desks/available")
    @Operation(summary = "Returns available desks from given time interval")
    public List<DtoDesk> fetchAllAvailableDesks(@RequestParam(required = true) String reservationStart,
                                                @RequestParam(required = true) String reservationEnd) {

        List<DtoReservations> reservations = reservationsService.fetchReservations(null, null, null, reservationStart, reservationEnd);
        List<DtoDesk> availableDesks = deskService.fetchDesks(null);

        for (DtoReservations r : reservations) {
            if (!Objects.equals(r.getReservationStart(), Timestamp.valueOf(reservationEnd)) && !Objects.equals(r.getReservationEnd(), Timestamp.valueOf(reservationStart))) {
                availableDesks.removeIf(dtoDesk -> dtoDesk.getDeskId() == r.getDeskId());
            }
        }

        return availableDesks;
    }
}