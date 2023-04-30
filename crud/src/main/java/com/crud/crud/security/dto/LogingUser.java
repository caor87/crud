package com.crud.crud.security.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LogingUser {

    @NonNull
    private String userName;
    @NonNull
    private String password;
}
