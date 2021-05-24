package com.example.freefire.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String enabled;
    private String title;
    private String fileName;
}
