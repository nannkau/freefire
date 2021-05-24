package com.example.freefire.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "role")
@Data
public class Role {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "flagDelete", nullable = false)
    private String flagDelete;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
