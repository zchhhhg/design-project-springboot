package com.example.project.repository;

import com.example.project.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface User2Repository extends CustomizedRepoistory<User, Integer> {

    @Query("SELECT u FROM User  u WHERE u.id=:id")
    User find(@Param("id") int id);
}
