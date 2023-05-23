package com.mlevensohn.base.services;

import com.mlevensohn.base.entities.Role;
import com.mlevensohn.base.utils.RoleEnum;

public interface RoleService {

    Role findByName(RoleEnum name);

}
