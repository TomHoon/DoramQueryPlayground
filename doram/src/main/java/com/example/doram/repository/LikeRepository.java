package com.example.doram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doram.entity.LikeEntity;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

      @Query(value = """

                  SELECT * FROM likes
                        """, nativeQuery = true)
      List<LikeEntity> findAll();

}
