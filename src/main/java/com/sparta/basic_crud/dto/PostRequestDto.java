package com.sparta.basic_crud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String author;
    private String password;
    private String title;
    private String content;
}