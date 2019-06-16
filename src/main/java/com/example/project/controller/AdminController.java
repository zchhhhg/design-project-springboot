package com.example.project.controller;

import com.example.project.ProjectApplication;
import com.example.project.entity.*;
import com.example.project.service.TaskService;
import com.example.project.service.ZiliaoService;
import com.example.project.service.TestService;
import com.example.project.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController<user> {
    @Autowired
    private ZiliaoService ziliaoService;
    @Autowired
    private TestService testService;
    @Autowired
    private TaskService taskService;

    /**
     * 添加后，将全部课程返回
     * @param user
     * @param uid
     * @return
     */
    @PostMapping("/allziliao")
    public Map getCourse(@RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");

        return Map.of("name", ziliaoService.MyZiliao(uid));
    }
    @PostMapping("/adduser")
    public Map postCourse(@RequestBody User user,@RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
ziliaoService.adduser(user);
        return Map.of("user", ziliaoService.MyZiliao(uid));
    }
    @PostMapping("/updateuser")
    public Map updateCourse(@RequestBody User user,@RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        ziliaoService.updateuser(user);
        return Map.of("user", ziliaoService.MyZiliao(uid));
    }
    @PostMapping("/deleteuser")
    public Map deleteCourse(@RequestBody User user,@RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        ziliaoService.deleteuser(user);
        return Map.of("user", ziliaoService.MyZiliao(uid));
    }
    @PostMapping("/alltest")
    public Map alltest( @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        return Map.of("Test",testService.alltest(uid));
    }
    @PostMapping("/addtest")
    public Map addtest(@RequestBody Test test,@RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        testService.addtest(test);
        return Map.of("Test",testService.alltest(uid));
    }

    @PostMapping("/allfptest")
    public Map allfptest( @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        return Map.of("UserTest",testService.allfptest(uid));
    }
    @PostMapping("/fptest")
    public Map fptest(@RequestBody UserTest test, @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        testService.addfptest(test);
        return Map.of("UserTest",testService.allfptest(uid));
    }
    @PostMapping("/deletefptest")
    public Map deletefptest(@RequestBody UserTest test, @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        testService.deletefptest(test);
        return Map.of("UserTest",testService.allfptest(uid));
    }
    @PostMapping("/alltask")
    public Map alltask( @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        return Map.of("UserTask",taskService.alltask(uid));
    }
    @PostMapping("/addtask")
    public Map addtask(@RequestBody Task task, @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        taskService.addtask(task);
        return Map.of("Task",taskService.alltask(uid));
    }
    @PostMapping("/updatetask")
    public Map updatetask(@RequestBody Task task, @RequestAttribute int uid) {
        Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
        logger.debug("1111");
        taskService.updatetask(task);
        return Map.of("Task", taskService.alltask(uid));
    }
    }

