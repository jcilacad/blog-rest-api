package com.ilacad.blog.blogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Login Dto Model Information")
public class LoginDto {

    @Schema(description = "Blog Login Username or Email")
    private String usernameOrEmail;
    @Schema(description = "Blog Login Password")
    private String password;
}
