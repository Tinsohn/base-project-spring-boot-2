package com.mlevensohn.base.controllers.dto;

import com.mlevensohn.base.utils.RoleEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto {

    private RoleEnum roleName;

}
