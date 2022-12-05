package com.sparta.basic_crud.service;

import com.sparta.basic_crud.dto.DeleteResponseDto;
import com.sparta.basic_crud.dto.PostRequestDto;
import com.sparta.basic_crud.dto.PostResponseDto;
import com.sparta.basic_crud.entity.Post;
import com.sparta.basic_crud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post postContent(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getContent() {
        List<Post> contents = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for (Post content : contents) {
            postResponseDtoList.add(new PostResponseDto(content, 200, "OK!"));
        }
        return postResponseDtoList;
    }

    @Transactional(readOnly = true)
    public PostResponseDto getIdContent(Long id) {
        Post post = checkPost(id);
        return new PostResponseDto(post, 200, "OK!");
    }

    @Transactional
    public PostResponseDto updateContent(Long id, PostRequestDto postRequestDto) {
        Post post = checkPost(id);
        if (post.getPassword().equals(postRequestDto.getPassword())) {
            post.update(postRequestDto);
            return new PostResponseDto(post, 200, "OK!");
        }
        return new PostResponseDto(400, "false");
    }

    @Transactional
    public DeleteResponseDto deleteContent(Long id, PostRequestDto postRequestDto) {
        Post post = checkPost(id);
        if (post.getPassword().equals(postRequestDto.getPassword())) {
            postRepository.delete(post);
            return new DeleteResponseDto(200, "OK!");
        }
        return new DeleteResponseDto(400, "false");
    }

    private Post checkPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("No Post Found")
        );
    }

}
