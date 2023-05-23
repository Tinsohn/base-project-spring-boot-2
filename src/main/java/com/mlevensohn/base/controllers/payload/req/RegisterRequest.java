package com.mlevensohn.base.controllers.payload.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\.\\-_@#\\$%^&+\\=]).{8,}$",
            message = "Password must contain at least 8 characters, one uppercase, one lowercase, one digit and one special character")
    private String password;
    @NotBlank(message = "E-mail is required")
    @Email(message = "Invalid e-mail")
    private String email;

}
