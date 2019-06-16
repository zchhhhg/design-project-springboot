package com.example.project.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
    public static final int USER_AUTHORITY = 1;
    public static final int ADMIN_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskname;
    private String detail;

    private int peoplenumber;
    private String status;


    @OneToMany(mappedBy = "taskname")
    private List<UserTask> usertask;

    private LocalDateTime starttime;
    private LocalDateTime endtime;
    // 在没有声明时默认为1
    @Column(columnDefinition = "DATETIME NOT NULL " + "DEFAULT CURRENT_TIMESTAMP ON UPDATE " + "CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime updateTime;
    @Column(columnDefinition = "TIMESTAMP NOT NULL " + "DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime insertTime;

    public Task(int id) {
        this.id = id;
    }
}
