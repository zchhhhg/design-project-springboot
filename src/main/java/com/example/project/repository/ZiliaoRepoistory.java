package com.example.project.repository;

import com.example.project.ProjectApplication;
import com.example.project.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZiliaoRepoistory extends CustomizedRepoistory<User,Integer> {
//指定学生全部资料

    @Query("SELECT h FROM User h ")
    List<User> list(@Param("cid") int cid);
}
