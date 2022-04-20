package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "DESK")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoDesk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deskId;

    @Column(name = "DESK_NAME")
    private String deskName;

    @Column(name = "ROOM_ID")
    private Long roomId;
}
