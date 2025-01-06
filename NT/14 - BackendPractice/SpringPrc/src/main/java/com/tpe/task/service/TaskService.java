package com.tpe.task.service;

import com.tpe.task.domain.Task;
import com.tpe.task.repository.Repository;
import com.tpe.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class TaskService {

    @Autowired
    private Repository repository;

    public void addTask(String title){
       int id= repository.findAll().size()+1;
        Task task=new Task(id,title);
       repository.save(task);
    }

    public List<Task> getAllTask(){
       return repository.findAll();
    }

    public Task getTaskById(int id){
        return repository.findById(id);
    }

    public void deleteTaskById(int id){
        repository.deleteById(id);
    }

    public void update(int id,String title){
        Task task=getTaskById(id);
        task.setTitle(title);
        repository.update(task);
    }

    @PostConstruct
    public void postConstructor(){
        System.out.println("------------Service Objesi oluşturuldu!");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("------------Service Objesi silindi!");
    }



}
