package com.crud.crud.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employes")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firsts_name")
    private String firstsName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    @Column(name = "document")
    private String document;
    @Column(name = "email")
    private String email;
}
