package com.example.project.service;

import com.example.project.ProjectApplication;
import com.example.project.entity.User;
import com.example.project.entity.Test;
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
public class TestService {
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
    private Test2Repoistory test2Repoistory;
    @Autowired
    private Test3Repoistory test3Repoistory;

    /**
     * 获取指定教师的所有课程
     * @param tid
     * @return
     */
    public List<Test> alltest(int tid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("2222");
        return testRepoistory.list(tid);
    }
    public List<UserTest> allfptest(int tid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("2222");
        return test2Repoistory.list(tid);
    }
public Test addtest(Test test){
    testRepoistory.save(test);
        return testRepoistory.refresh(test);
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
    public UserTest deletefptest(UserTest UserTest){
        int userId = UserTest.getId();
        UserTest olduser= test3Repoistory.find(userId);
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug(String.valueOf(userId));
        em.remove(olduser);
        return test3Repoistory.find(userId);
    }

}
