package com.example.doram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.doram.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = """

              SELECT * FROM users WHERE name LIKE %:name%

            """, nativeQuery = true)
    List<UserEntity> findByNameNative(@Param("name") String name);

    @Query(value = """
              SELECT * FROM users
            """, nativeQuery = true)
    List<UserEntity> findAll();

    @Query(value = """

            SELECT * FROM users
            WHERE city = :city

            """, nativeQuery = true)
    List<UserEntity> findByCity(@Param("city") String city);

    @Query(value = """

            SELECT * FROM users
            WHERE birth_year = :year

            """, nativeQuery = true)
    List<UserEntity> findByYear(@Param("year") String year);

    @Query(value = """

            SELECT * FROM users
            order by birth_year :order

            """, nativeQuery = true)
    List<UserEntity> findByOrder(@Param("order") String order);

    @Query(value = """

            SELECT COUNT(*) FROM users

            """, nativeQuery = true)
    List<UserEntity> findCounts();

    @Query(value = """

            SELECT * FROM users
            WHERE city like :keyword

            """, nativeQuery = true)
    List<UserEntity> findByKeyword(@Param("keyword") String keyword);

}
