package com.example.rental_hive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long Id;

    private String fullName;

    private String email;

    private String mobile;

    private Boolean isAdmin;

}
