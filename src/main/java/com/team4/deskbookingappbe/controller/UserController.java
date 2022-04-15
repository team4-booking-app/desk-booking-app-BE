package com.team4.deskbookingappbe.controller;

import com.team4.deskbookingappbe.model.api.CreateUserRequest;
import com.team4.deskbookingappbe.model.api.UserResponse;
import com.team4.deskbookingappbe.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/registration")
    @Operation(summary = "Create new instance in DB")
    @ApiResponse(
            responseCode = "201",
            description = "New USER successfully created in DB",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public Long createUser(@Validated @RequestBody CreateUserRequest request) {
        return userService.createUser(request).getId();
    }
    @GetMapping(value = "/users")
    public List<UserResponse> fetchUsers(@RequestParam(required = false) String email) {
        return userService.fetchUsers(email).stream()
                .map(p -> new UserResponse(p.getFirstName(), p.getLastName(), p.getEmail(), p.getPassword()))
                .collect(Collectors.toList());
    }

}
