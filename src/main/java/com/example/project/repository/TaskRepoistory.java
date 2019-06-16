package com.example.project.repository;

import com.example.project.entity.Task;
import com.example.project.entity.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//获取全部考试列表
@Repository
public interface TaskRepoistory extends CustomizedRepoistory <Task, Integer> {
    @Query("SELECT h FROM Task h ")
    List<Task> list(@Param("cid") int cid);
}
