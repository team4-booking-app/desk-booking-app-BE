package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Entity(name = "USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "USERID", nullable = false)
    private Long userID;

    @Column(name = "FIRST_NAME", nullable = false)
    private  String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private  String lastName;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
