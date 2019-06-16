package com.example.project.repository;

import com.example.project.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//获取全部考试列表
@Repository
public interface Task2Repoistory extends CustomizedRepoistory <Task, Integer> {

    @Query("SELECT h FROM Task h WHERE h.id=:id ")
   Task find(@Param("id") int id);;
}
