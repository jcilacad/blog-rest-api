package com.ilacad.blog.blogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Error Details Model Information")
public class ErrorDetails {

    @Schema(description = "Error Details Timestamp")
    private Date timestamp;
    @Schema(description = "Error Details Message")
    private String message;
    @Schema(description = "Details")
    private String details;

}
