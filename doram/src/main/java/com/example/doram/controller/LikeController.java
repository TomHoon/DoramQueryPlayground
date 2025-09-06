package com.example.doram.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doram.entity.LikeEntity;
import com.example.doram.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like")
public class LikeController {

   private final LikeRepository likeRepository;

   @GetMapping("/likes")
   public List<LikeEntity> getLikes() {
      return likeRepository.findAll();
   }

}
