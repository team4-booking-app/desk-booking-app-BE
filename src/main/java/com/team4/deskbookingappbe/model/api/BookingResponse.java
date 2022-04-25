package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    @Schema(description = "Reservations id", example = "1")
    private Long reservationId;
    @Schema(description = "User email", example = "belekas@swed")
    private String userEmail;
    @Schema(description = "Desk id", example = "3")
    private Long deskId;
    @Schema(description = "Desk name", example = "Desk 3")
    private String deskName;
    @Schema(description = "Room id", example = "2")
    private Long roomId;
    @Schema(description = "Room name", example = "Room 420")
    private String roomName;
    @Schema(description = "Reservations start", example = "2022-04-20 15:00:00")
    private String reservationStart;
    @Schema(description = "Reservations end", example = "2022-04-20 16:00:00")
    private String reservationEnd;
}