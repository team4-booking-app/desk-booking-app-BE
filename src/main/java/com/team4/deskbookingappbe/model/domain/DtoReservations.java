package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "RESERVATIONS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoReservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "DESK_ID")
    private Long deskId;

    @Column(name = "RESERVATION_START")
    private Timestamp reservationStart;

    @Column(name = "RESERVATION_END")
    private Timestamp reservationEnd;

}
