package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CustomizedRepoistory<T, ID> extends JpaRepository<T, ID> {
    T refresh(T t);
}