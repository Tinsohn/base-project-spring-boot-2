package com.mlevensohn.base.controllers.payload.res;

import com.mlevensohn.base.controllers.dto.UserDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {

    private UserDto user;
    private String accessToken;

}
