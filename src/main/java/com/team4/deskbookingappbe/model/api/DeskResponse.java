package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeskResponse {
    @Schema(description = "Desk id", example = "1")
    private Long deskId;
    @Schema(description = "Desk name", example = "Desk 1")
    private String deskName;
    @Schema(description = "Desk room id", example = "1")
    private Long roomId;
}
