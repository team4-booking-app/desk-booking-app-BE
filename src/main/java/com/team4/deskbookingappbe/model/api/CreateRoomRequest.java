package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CreateRoomRequest {
    @NonNull
    @Schema(description = "Room name", example = "Room 1")
    private String roomName;
}
