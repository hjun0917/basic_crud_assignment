package com.sparta.basic_crud.dto;

import com.sparta.basic_crud.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long id;
    private String author;
    private String title;
    private String content;
    private int statusCode;
    private String msg;

    public PostResponseDto(Post post, int statusCode, String msg) {
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.author = post.getAuthor();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public PostResponseDto(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }
}
