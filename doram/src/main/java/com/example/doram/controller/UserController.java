package com.example.doram.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doram.entity.UserEntity;
import com.example.doram.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

   private final UserRepository userRepository;

   // ✅️전체
   @GetMapping("/users")
   public List<UserEntity> findAll() {
      return userRepository.findAll();
   }

   // ✅️{city} 만
   @GetMapping("/users/city/{city}")
   public List<UserEntity> findByCity(@PathVariable(name = "city") String city) {

      return userRepository.findByCity(city);
   }

   // ✅️{x} 년생만
   @GetMapping("/users/year/{year}")
   public List<UserEntity> findByYear(@PathVariable(name = "year") String year) {

      return userRepository.findByCity(year);
   }

   // ✅️생일 {오름/내림} 차순
   @GetMapping("/users/order/{order}")
   public List<UserEntity> findByOrder(@PathVariable(name = "order") String order) {

      return userRepository.findByOrder(order);
   }

   // ✅️유저 총 카운트
   @GetMapping("/users/counts")
   public List<UserEntity> findCounts() {

      return userRepository.findCounts();
   }

   // ✅️'구'가 들어있는 유저
   @GetMapping("/users/keyword/{keyword}")
   public List<UserEntity> findByKeyword(@PathVariable(name = "keyword") String keyword) {

      keyword = "%" + keyword + "%";
      return userRepository.findByKeyword(keyword);
   }

}
