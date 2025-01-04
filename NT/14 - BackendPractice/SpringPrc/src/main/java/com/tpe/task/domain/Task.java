package com.tpe.task.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Task {

    private int id;

    private String title;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstructor(){
        System.out.println("-------------Task oluşturuldu!!");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-------------Task silindi!!!");
    }
}
