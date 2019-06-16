package com.example.project.controller;

import com.example.project.ProjectApplication;
import com.example.project.component.EncryptorComponent;
import com.example.project.entity.User;
import com.example.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {
    private static final String STUDENT_ROLE = "bb63e5f7e0f2ffae845c";
    private static final String ADMIN_ROLE = "6983f953b49c88210cb9";
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EncryptorComponent encryptorComponent;

    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("!!niubi");
        Optional.ofNullable(userService.getUser(user.getUsername()))
                .ifPresentOrElse(u -> {
                    if (!passwordEncoder.matches(user.getPassword(), u.getPassword())) {

                        logger.debug("666");
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误！");
                    }
                    Map map = Map.of("uid", u.getId(), "aid", u.getPower());
                    // 生成加密token
                    String token = encryptorComponent.encrypt(map);
                    // 在header创建自定义的权限
                    logger.debug(token);
                    logger.debug("11111");
                    response.setHeader("token", token);
                    String role = null;
                    if (u.getPower() == User.USER_AUTHORITY) {
                        role = STUDENT_ROLE;
                    } if (u.getPower() == User.ADMIN_AUTHORITY) {
                        role = ADMIN_ROLE;
                    }
                    response.setHeader("role", role);
                }, () -> {

                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误00000");
                });
    }
}
