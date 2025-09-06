package com.example.doram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;

   private String username;

   private Integer birthYear;

   private String city;

}
