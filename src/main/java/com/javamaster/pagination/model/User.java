package com.javamaster.pagination.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private Integer age;

    private String email;
}
