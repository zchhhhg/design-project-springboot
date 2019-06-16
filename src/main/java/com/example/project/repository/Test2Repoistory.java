package com.example.project.repository;

import com.example.project.entity.Test;
import com.example.project.entity.UserTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//获取全部考试列表
@Repository
public interface Test2Repoistory extends CustomizedRepoistory <UserTest, Integer> {
    @Query("SELECT h FROM UserTest h ")
    List<UserTest> list(@Param("cid") int cid);
}
