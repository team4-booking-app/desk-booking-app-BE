package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private  String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private  String lastName;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
