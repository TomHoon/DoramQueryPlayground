package com.example.doram.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long postId;

   private Long userId;

   private String content;

   private LocalDate postDate;

}
