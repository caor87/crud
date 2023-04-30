package com.crud.crud.security.service;

import com.crud.crud.security.entity.Role;
import com.crud.crud.security.enums.RoleName;
import com.crud.crud.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

}
