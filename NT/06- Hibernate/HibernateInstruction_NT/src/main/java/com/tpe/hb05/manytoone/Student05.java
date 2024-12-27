package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {
    @Id
    private Integer id;

    private String name;

    private int grade;

    private LocalDateTime createOn;//olusturuldugu tarih diğer bir değişle üniversiteye kayıt tarihi

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    public Student05(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student05() {
    }

    @PrePersist//database'e kaydedilirken bu methodun calısmasını saglıyordu
    public void prePersist(){
        createOn=LocalDateTime.now();
    }
      //getter-setter

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }


    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
