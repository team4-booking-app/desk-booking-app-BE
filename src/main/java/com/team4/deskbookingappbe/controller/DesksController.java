package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.api.DeskResponse;
import com.team4.deskbookingappbe.service.DeskDataService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class DesksController {
    private final DeskDataService deskDataService;

    @Autowired
    public DesksController(DeskDataService deskDataService) {
        this.deskDataService = deskDataService;
    }

    @PostMapping(path = "/desks")
    @Operation(summary = "Create new desk")
    public Long createDesk(@Validated @RequestBody CreateDeskRequest request){
        return deskDataService.createDesk(request).getDeskId();
    }

    @GetMapping(value = "/desks")
    @Operation(summary = "Get all desks list from database")
    public List<DeskResponse> fetchDesks(@RequestParam(required = false) Long id){
        return deskDataService.fetchDesks(id).stream()
                .map(desk -> new DeskResponse(desk.getDeskId(),desk.getDeskName(),desk.getRoomId()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/desks/{id}")
    @Operation(summary = "Delete desk from database")
    public ResponseEntity<Void> deleteDesk(@PathVariable Long id){
        deskDataService.deleteDesk(id);
        return ResponseEntity.noContent().build();
    }
}
