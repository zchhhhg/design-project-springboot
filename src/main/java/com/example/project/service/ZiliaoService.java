package com.example.project.service;

import com.example.project.ProjectApplication;
import com.example.project.entity.User;
import com.example.project.repository.ZiliaoRepoistory;
import com.example.project.repository.User2Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ZiliaoService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ZiliaoRepoistory ZiliaoRepoistory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private User2Repository UserRepository;
    /**
     * 获取指定教师的所有课程
     * @param tid
     * @return
     */
    public List<User> MyZiliao(int tid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("2222");
        return ZiliaoRepoistory.list(tid);
    }
public User adduser(User user){
    user.setPassword(passwordEncoder.encode(user.getUsername()));
        ZiliaoRepoistory.save(user);
        return ZiliaoRepoistory.refresh(user);
}
    public User deleteuser(User user){
        int userId = user.getId();
        String username=user.getUsername();
        User olduser= UserRepository.find(userId);
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug(String.valueOf(userId));
        logger.debug(username);
        em.remove(olduser);
        return UserRepository.find(userId);
    }
    public User updateuser(User user){
        int userId = user.getId();
        String username=user.getUsername();
        User olduser= UserRepository.find(userId);
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug(String.valueOf(userId));
        logger.debug(username);
        olduser.setUsername(user.getUsername());
        olduser.setPower(user.getPower());
        olduser.setPassword(user.getPassword());
        String b=user.getPassword();
        olduser.setMobilenumber(user.getMobilenumber());
        olduser.setJianjie(user.getJianjie());
        olduser.setZhicheng(user.getZhicheng());
        olduser.setName(user.getName());
        olduser.setPassword(passwordEncoder.encode(user.getPassword()));
        ZiliaoRepoistory.save(olduser);
        return UserRepository.find(userId);
    }
}
