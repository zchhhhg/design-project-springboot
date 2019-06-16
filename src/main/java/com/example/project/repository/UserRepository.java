package com.example.project.repository;

import com.example.project.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomizedRepoistory<User, Integer> {
    @Query("SELECT u FROM User  u WHERE u.username=:username")
    User find(@Param("username") String username);
}
