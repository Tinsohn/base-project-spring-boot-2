package com.mlevensohn.base.models;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private UUID userId;
    private String username;
    private String email;
    private Set<RoleDto> roles;
//    private Set<RoleEnum> roles;

}
