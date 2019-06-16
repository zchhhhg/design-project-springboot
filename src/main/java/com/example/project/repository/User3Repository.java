package com.example.project.repository;

import com.example.project.entity.User;
import com.example.project.entity.UserTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface User3Repository extends CustomizedRepoistory<UserTest, Integer> {

    @Query("SELECT u FROM UserTest  u WHERE u.id=:id")
    UserTest find(@Param("id")int id);
}
