package com.example.doram.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doram.entity.PostEntity;
import com.example.doram.repository.PostRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

   private final PostRepository postRepository;

   @GetMapping("/posts")
   public List<PostEntity> getPosts() {
      return postRepository.findAll();
   }

}
