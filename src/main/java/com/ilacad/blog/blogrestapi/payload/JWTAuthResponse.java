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
@Schema(description = "JWT Auth Response")
public class JWTAuthResponse {

    @Schema(description = "Auth Response Access Token")
    private String accessToken;
    @Schema(description = "Auth Response Bearer")
    private String tokenType = "Bearer";
}
