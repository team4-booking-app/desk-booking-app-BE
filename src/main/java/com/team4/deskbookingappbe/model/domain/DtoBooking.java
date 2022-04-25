package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "DESK_ID")
    private Long deskId;

    @Column(name = "DESK_NAME")
    private String deskName;

    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "RESERVATION_START")
    private Timestamp reservationStart;

    @Column(name = "RESERVATION_END")
    private Timestamp reservationEnd;
}