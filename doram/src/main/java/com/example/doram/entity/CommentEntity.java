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
public class CommentEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long commentId;

   private Long userId;

   private Long postId;

   private String commentText;

   private LocalDate commentDate;

}
