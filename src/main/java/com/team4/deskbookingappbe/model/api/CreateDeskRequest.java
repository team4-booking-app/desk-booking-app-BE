package com.team4.deskbookingappbe.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CreateDeskRequest {
    @NonNull
    @Schema(description = "Desk name", example = "Desk 1")
    private String deskName;
    @NonNull
    @Schema(description = "Desk room id", example = "1")
    private Long roomId;
}
