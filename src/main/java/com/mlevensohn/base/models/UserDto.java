package com.mlevensohn.base.models;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Long userId;
    private String username;
    private String email;
    private Set<RoleDto> roles;
//    private Set<RoleEnum> roles;

}
