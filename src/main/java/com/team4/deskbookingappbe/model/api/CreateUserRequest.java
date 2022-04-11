package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    @NonNull
    @Size(min = 3, max = 30)
    @Schema(description = "User First name", example = "Karolis")
    private String firstName;
    @NonNull
    @Size(min = 3, max = 50)
    @Schema(description = "User Last name", example = "Vaskelis")
    private String lastName;
    @NonNull
    @Email
    @Schema(description = "User email", example = "email@gmail.com")
    private String email;
    @NonNull
    @Size(min = 3)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{2,}$")
    @Schema(description = "User Password", example = "Test1")
    private String password;
}
