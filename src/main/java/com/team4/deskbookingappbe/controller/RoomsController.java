package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.api.RoomResponse;
import com.team4.deskbookingappbe.service.RoomDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class RoomsController {
    private final RoomDataService roomDataService;

    public RoomsController(RoomDataService roomDataService) {
        this.roomDataService = roomDataService;
    }

    @PostMapping(path = "/rooms")
    @Operation(summary = "Create new room")
    public Long createDesk(@Validated @RequestBody CreateRoomRequest request){
        return roomDataService.createRoom(request).getRoomId();
    }

    @GetMapping(value = "/rooms")
    @Operation(summary = "Get all rooms list from database")
    public List<RoomResponse> fetchRooms(@RequestParam(required = false) Long id){
        return roomDataService.fetchRooms(id).stream()
                .map(room -> new RoomResponse(room.getRoomId(),room.getRoomName()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/rooms/{id}")
    @Operation(summary = "Delete room from database")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        roomDataService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
