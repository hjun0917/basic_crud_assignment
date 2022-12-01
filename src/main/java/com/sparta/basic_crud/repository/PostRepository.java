package com.sparta.basic_crud.repository;

import com.sparta.basic_crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}