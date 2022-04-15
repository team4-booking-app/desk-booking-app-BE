package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    @Schema(description = "Person first name", example = "Karolis")
    private String firstName;

    @Schema(description = "Person last name", example = "L")
    private String lastName;

    @Schema(description = "Person email", example = "email@gmail.com")
    private String email;

    @Schema(description = "User password", example = "Encrypted password")
    private String password;
}
