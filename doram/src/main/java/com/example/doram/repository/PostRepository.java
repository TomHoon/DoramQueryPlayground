package com.example.doram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.doram.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

   @Query(value = """
         SELECT * FROM posts
               """, nativeQuery = true)
   List<PostEntity> findAll();

}
