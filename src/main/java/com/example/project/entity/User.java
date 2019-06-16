package com.example.project.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.lang.String;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int USER_AUTHORITY = 1;
    public static final int ADMIN_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String name;
    private String zhicheng;
    private String jianjie;
    private String mobilenumber;
   @OneToMany(mappedBy = "name")
    private List<UserTest> usertest;
    @OneToMany(mappedBy = "name")
    private List<UserTask> usertask;
    private int power=1;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 在没有声明时默认为1
    @Column(columnDefinition = "DATETIME NOT NULL " + "DEFAULT CURRENT_TIMESTAMP ON UPDATE " + "CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime updateTime;
    @Column(columnDefinition = "TIMESTAMP NOT NULL " + "DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime insertTime;

    public User(int id) {
        this.id = id;
    }
}
