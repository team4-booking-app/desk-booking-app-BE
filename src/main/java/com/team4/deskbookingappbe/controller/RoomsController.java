package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.api.RoomResponse;
import com.team4.deskbookingappbe.service.RoomService;
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
public class RoomsController {
    private final RoomService roomService;

    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(path = "/rooms")
    @Operation(summary = "Create new room")
    public Long createRoom(@Validated @RequestBody CreateRoomRequest request){
        return roomService.createRoom(request).getRoomId();
    }

    @GetMapping(value = "/rooms")
    @Operation(summary = "Get all rooms list from database")
    public List<RoomResponse> fetchRooms(@RequestParam(required = false) Long roomId) {
        List<RoomResponse> rooms = roomService.fetchRooms(roomId).stream()
                .map(room -> new RoomResponse(room.getRoomId(), room.getRoomName()))
                .collect(Collectors.toList());
        if (rooms.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Room not found with requested id"
            );
        }
        return rooms;
    }

    @DeleteMapping(value = "/rooms/{roomId}")
    @Operation(summary = "Delete room from database")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId){
        roomService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }
}
