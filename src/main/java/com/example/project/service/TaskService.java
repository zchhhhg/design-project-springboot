package com.example.project.service;

import com.example.project.ProjectApplication;
import com.example.project.entity.Task;
import com.example.project.entity.Test;
import com.example.project.entity.User;
import com.example.project.entity.UserTest;
import com.example.project.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class TaskService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ZiliaoRepoistory ZiliaoRepoistory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private User2Repository UserRepository;
    @Autowired
    private User3Repository User3Repository;
    @Autowired
    private TestRepoistory testRepoistory;
    @Autowired
    private TaskRepoistory taskRepoistory;
    @Autowired
    private Task2Repoistory task2Repoistory;
    @Autowired
    private Test2Repoistory test2Repoistory;
    /**
     * 获取指定教师的所有课程
     * @param tid
     * @return
     */
    public List<Task> alltask(int tid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("2222");
        return taskRepoistory.list(tid);
    }
    public List<UserTest> allfptest(int tid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("2222");
        return test2Repoistory.list(tid);
    }
public Task addtask(Task task){
    taskRepoistory.save(task);
        return taskRepoistory.refresh(task);
}
    public Task updatetask(Task  task){
        int Id = task.getId();
        Task oldtask= task2Repoistory.find(Id);
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        oldtask.setDetail(task.getDetail());
        oldtask.setEndtime(task.getEndtime());
        oldtask.setStarttime(task.getStarttime());
        oldtask.setTaskname(task.getTaskname());
        oldtask.setStatus(task.getStatus());
        taskRepoistory.save(oldtask);
        return task2Repoistory.find(Id);
    }
    public UserTest addfptest(UserTest test){
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("111:::::::"+test.getName());
        test2Repoistory.save(test);
        int c=test.getName().getId();
        User olduser= UserRepository.find(c);
        UserTest userTest=User3Repository.find(c);
        List<UserTest> a = olduser.getUsertest();
       // String b=u.getUsername();

        a.add(userTest);
        olduser.setUsertest(a);
        ZiliaoRepoistory.save(olduser);
        return test2Repoistory.refresh(test);
    }

}
