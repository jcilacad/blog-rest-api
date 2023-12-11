package com.ilacad.blog.blogrestapi.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String name;
    private String email;
    private String body;
}
