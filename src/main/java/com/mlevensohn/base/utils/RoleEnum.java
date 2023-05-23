package com.mlevensohn.base.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

}
