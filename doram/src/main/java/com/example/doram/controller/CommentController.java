package com.example.doram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doram.entity.CommentEntity;
import com.example.doram.repository.CommentRepostiory;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

   private final CommentRepostiory commentRepostiory;

   @GetMapping("/comments")
   public List<CommentEntity> getComments() {
      return commentRepostiory.findAll();
   }

}
