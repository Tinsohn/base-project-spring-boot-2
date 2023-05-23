package com.mlevensohn.base.services.impl;

import com.mlevensohn.base.entities.Role;
import com.mlevensohn.base.repositories.RoleRepository;
import com.mlevensohn.base.services.RoleService;
import com.mlevensohn.base.utils.RoleEnum;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(RoleEnum name) {
        return roleRepository.findRoleByName(name);
    }
}
