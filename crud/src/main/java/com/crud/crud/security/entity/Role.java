package com.crud.crud.security.entity;

import com.crud.crud.security.enums.RoleName;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role() {
    }
}
