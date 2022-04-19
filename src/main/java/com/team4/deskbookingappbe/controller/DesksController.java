package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.api.DeskResponse;
import com.team4.deskbookingappbe.service.DeskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class DesksController {
    private final DeskService deskService;

    @Autowired
    public DesksController(DeskService deskService) {
        this.deskService = deskService;
    }

    @PostMapping(path = "/desks")
    @Operation(summary = "Create new desk")
    public Long createDesk(@Validated @RequestBody CreateDeskRequest request){
        return deskService.createDesk(request).getDeskId();
    }

    @GetMapping(value = "/desks")
    @Operation(summary = "Get all desks list from database")
    public List<DeskResponse> fetchDesks(@RequestParam(required = false) Long deskId){
        List<DeskResponse> desks = deskService.fetchDesks(deskId).stream()
                .map(desk -> new DeskResponse(desk.getDeskId(),desk.getDeskName(),desk.getRoomId()))
                .collect(Collectors.toList());
        if(desks.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Desk not found with requested id"
            );
        }
        return desks;
    }

    @DeleteMapping(value = "/desks/{deskId}")
    @Operation(summary = "Delete desk from database")
    public ResponseEntity<Void> deleteDesk(@PathVariable Long deskId){
        deskService.deleteDesk(deskId);
        return ResponseEntity.noContent().build();
    }
}
