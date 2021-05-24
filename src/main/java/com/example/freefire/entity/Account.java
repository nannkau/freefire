package com.example.freefire.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String type;
    private String ipAddress;
}
