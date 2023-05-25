package com.mlevensohn.base.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

}
