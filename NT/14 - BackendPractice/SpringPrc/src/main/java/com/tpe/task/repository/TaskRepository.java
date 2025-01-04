package com.tpe.task.repository;

import com.tpe.task.domain.Task;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepository implements Repository{
    private List<Task> taskList=new ArrayList<>();

    @Override
    public void save(Task task) {
        taskList.add(task);
    }

    @Override
    public List<Task> findAll() {
        return taskList;
    }

    @Override
    public Task findById(int id) {
        return taskList.stream().
                filter(task -> task.getId()==id).
                findFirst().
                orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Task task=findById(id);
        taskList.remove(task);
    }

    @Override
    public void update(Task task) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId()== task.getId()){
                taskList.set(i,task);
            }

        }

    }
    @PostConstruct
    public void postConstructor(){
        System.out.println("-----------------Repository Objesi oluştur!");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----------------Repository Objesi silindi!");
    }
}
