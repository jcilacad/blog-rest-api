package com.ilacad.blog.blogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Post Response Model Information")
public class PostResponse {

    @Schema(description = "Blog Post Response Content")
    private List<PostDto> content;
    @Schema(description = "Blog Post Response Page Number")
    private int pageNo;
    @Schema(description = "Blog Post Response Page Size")
    private int pageSize;
    @Schema(description = "Blog Post Response Page Element")
    private long totalElement;
    @Schema(description = "Blog Post Response Total Pages")
    private int totalPages;
    @Schema(description = "Blog Post Response Last")
    private boolean last;
}
