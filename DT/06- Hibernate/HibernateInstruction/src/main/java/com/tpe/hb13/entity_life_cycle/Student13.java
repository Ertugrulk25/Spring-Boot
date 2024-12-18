package com.tpe.hb13.entity_life_cycle;

import javax.persistence.*;

@Entity
public class Student13 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer grade;

    public Student13() {
    }

    public Student13(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student13{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @PrePersist
    public void prePersist(){
        System.out.println("------------------Öğrenci kaydediliyor...");
    }

    @PostPersist
    public void postPersist(){
        System.out.println("------------------Öğrenci kaydedildi...");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("------------------Öğrenci güncelleniyor...");
    }

    @PostUpdate
    public void postUpdate(){
        System.out.println("------------------Öğrenci güncellendi...");
    }

    @PreRemove
    public void preRemove(){
        System.out.println("------------------Öğrenci siliniyor...");
    }

    @PostRemove
    public void postRemove(){
        System.out.println("------------------Öğrenci silindi...");
    }

    @PostLoad
    public void postLoad(){
        System.out.println("Öğrenci yüklendi...");
    }

}
