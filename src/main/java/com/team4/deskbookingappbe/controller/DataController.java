package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.*;
import com.team4.deskbookingappbe.service.DeskDataService;
import com.team4.deskbookingappbe.service.ReservationsDataService;
import com.team4.deskbookingappbe.service.RoomDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class DataController {

    private final DeskDataService deskDataService;
    private final RoomDataService roomDataService;
    private final ReservationsDataService reservationsDataService;

    @Autowired
    public DataController(DeskDataService deskDataService, RoomDataService roomDataService, ReservationsDataService reservationsDataService) {
        this.deskDataService = deskDataService;
        this.roomDataService = roomDataService;
        this.reservationsDataService = reservationsDataService;
    }

    @PostMapping(path = "/create/desk")
    @Operation(summary = "Create new desk")
    public Long createDesk(@Validated @RequestBody CreateDeskRequest request){
        return deskDataService.createDesk(request).getDeskId();
    }

    @PostMapping(path = "/create/room")
    @Operation(summary = "Create new room")
    public Long createDesk(@Validated @RequestBody CreateRoomRequest request){
        return roomDataService.createRoom(request).getRoomId();
    }

    @PostMapping(path = "/create/reservation")
    @Operation(summary = "Create new reservation")
    public Long createDesk(@Validated @RequestBody CreateReservationsRequest request){
        return reservationsDataService.createReservation(request).getReservationId();
    }
    @GetMapping(value = "/get/desks")
    @Operation(summary = "Get all desks list from database")
    public List<DeskResponse> fetchDesks(@RequestParam(required = false) Long id){
        return deskDataService.fetchDesks(id).stream()
                .map(desk -> new DeskResponse(desk.getDeskId(),desk.getDeskName(),desk.getRoomId()))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/get/rooms")
    @Operation(summary = "Get all rooms list from database")
    public List<RoomResponse> fetchRooms(@RequestParam(required = false) Long id){
        return roomDataService.fetchRooms(id).stream()
                .map(room -> new RoomResponse(room.getRoomId(),room.getRoomName()))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/get/reservations")
    @Operation(summary = "Get all reservations list from database")
    public List<ReservationsResponse> fetchReservations(@RequestParam(required = false) Long id){
        return reservationsDataService.fetchReservations(id).stream()
                .map(reservation -> new ReservationsResponse(reservation.getReservationId(),reservation.getUserEmail(),reservation.getDeskId(),reservation.getReservationStart(),reservation.getReservationEnd()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/delete/desk/{id}")
    @Operation(summary = "Delete desk from database")
    public ResponseEntity<Void> deleteDesk(@PathVariable Long id){
        deskDataService.deleteDesk(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/room/{id}")
    @Operation(summary = "Delete room from database")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        roomDataService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/reservation/{id}")
    @Operation(summary = "Delete reservation from database")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        reservationsDataService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
