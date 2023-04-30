package com.crud.crud.security.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import java.util.HashSet;
import java.util.Set;

@Data
public class NewUser {

    @NotNull
    @NotFound
    private String name;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Set<String> roles = new HashSet<>();
}
