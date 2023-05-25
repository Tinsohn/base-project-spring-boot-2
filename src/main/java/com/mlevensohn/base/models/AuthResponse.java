package com.mlevensohn.base.models;

import com.mlevensohn.base.models.UserDto;
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
