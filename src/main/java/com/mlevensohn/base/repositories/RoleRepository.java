package com.mlevensohn.base.repositories;

import com.mlevensohn.base.entities.Role;
import com.mlevensohn.base.utils.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findRoleByName(RoleEnum name);

}
