package com.sparta.basic_crud.controller;

import com.sparta.basic_crud.dto.DeleteResponseDto;
import com.sparta.basic_crud.dto.PostRequestDto;
import com.sparta.basic_crud.dto.PostResponseDto;
import com.sparta.basic_crud.entity.Post;
import com.sparta.basic_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public Post postContent(@RequestBody PostRequestDto postRequestDto) {
       return postService.postContent(postRequestDto);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getContents() {
        return postService.getContent();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto getIdContent(@PathVariable Long id) {
        return postService.getIdContent(id);
    }

    @PutMapping("/post/{id}")
    public PostResponseDto updateContent(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updateContent(id, postRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public DeleteResponseDto deleteContent(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.deleteContent(id, postRequestDto);
    }


}