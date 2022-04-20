package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
public class CreateReservationsRequest {
    @NonNull
    @Schema(description = "User email", example = "test@test.com")
    private String userEmail;
    @NonNull
    @Schema(description = "Desk room id", example = "1")
    private Long deskId;
    @NonNull
    @Schema(description = "Reservation start", example = "2022-04-20 15:00:00")
    private String reservationStart;
    @NonNull
    @Schema(description = "Reservation end", example = "2022-04-20 16:00:00")
    private String reservationEnd;
}
