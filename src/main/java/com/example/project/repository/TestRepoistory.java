package com.example.project.repository;

import com.example.project.entity.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//获取全部考试列表
@Repository
public interface TestRepoistory extends CustomizedRepoistory <Test, Integer> {
    @Query("SELECT h FROM Test h ")
    List<Test> list(@Param("cid") int cid);
}
