package com.tpe.task.repository;

import com.tpe.task.domain.Task;

import java.util.List;

public interface Repository {//crud

    void save(Task task);

    List<Task> findAll();

    Task findById(int id);

    void deleteById(int id);

    void update(Task task);

}
