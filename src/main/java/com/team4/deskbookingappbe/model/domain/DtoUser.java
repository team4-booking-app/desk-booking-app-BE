package com.team4.deskbookingappbe.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private  String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private  String lastName;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

}
