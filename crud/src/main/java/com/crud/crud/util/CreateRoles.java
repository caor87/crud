package com.crud.crud.util;

import com.crud.crud.security.entity.Role;
import com.crud.crud.security.enums.RoleName;
import com.crud.crud.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Lo ejecuto una sola vez para crear los roles
 */
// @Component
// public class CreateRoles implements CommandLineRunner {
public class CreateRoles {

    /*@Autowired
    RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        Role roleUser = new Role(RoleName.ROLE_USER);
        roleService.save(roleAdmin);
        roleService.save(roleUser);
    }*/
}
