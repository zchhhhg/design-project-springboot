package com.example.project.service;

import com.example.project.ProjectApplication;
import com.example.project.entity.User;
import com.example.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
public class InitService implements InitializingBean {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug(String.valueOf(userRepository.count()));
        if (userRepository.count() == 0) {
            User user = new User();
            user.setPower(User.ADMIN_AUTHORITY);
            user.setUsername("kfzjw008");
            user.setPassword(passwordEncoder.encode("kfzjw0000"));
            user.setName("张峻巍");
            userRepository.save(user);
        }
    }
}
