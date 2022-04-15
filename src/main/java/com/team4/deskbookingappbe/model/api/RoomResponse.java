package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomResponse {
    @Schema(description = "Room id", example = "1")
    private Long roomId;
    @Schema(description = "Room name", example = "Room 1")
    private String roomName;
}
