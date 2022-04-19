package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationsResponse {
    @Schema(description = "Reservation id", example = "1")
    private Long reservationId;
    @Schema(description = "User email", example = "test@test.com")
    private String userEmail;
    @Schema(description = "Desk room id", example = "1")
    private Long deskId;
    @Schema(description = "Reservation start", example = "2022-04-20 15:00:00")
    private String reservationStart;
    @Schema(description = "Reservation end", example = "2022-04-20 16:00:00")
    private String reservationEnd;
}
