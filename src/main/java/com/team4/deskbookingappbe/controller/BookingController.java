package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.BookingResponse;
import com.team4.deskbookingappbe.model.domain.DtoBooking;
import com.team4.deskbookingappbe.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(value = "/bookings")
    @Operation(summary = "Returns all bookings and it's info for given user")
    public List<BookingResponse> fetchBookings(@RequestParam(required = true) String userEmail) {
        List<BookingResponse> bookings = bookingService.fetchBookings(userEmail).stream()
                .filter(dtoBooking -> dtoBooking.getReservationEnd().toLocalDateTime().compareTo(LocalDateTime.now()) >= 0)
                .map(booking -> new BookingResponse(booking.getReservationId(), booking.getUserEmail(), booking.getDeskId(), booking.getDeskName(), booking.getRoomId(), booking.getRoomName(), booking.getReservationStart().toString().substring(0, 19), booking.getReservationEnd().toString().substring(0, 19)))
                .collect(Collectors.toList());
        if (bookings.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bookings not found"
            );
        } else {
            return bookings;
        }
    }
}
