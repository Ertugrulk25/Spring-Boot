package com.tpe.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {
    @Id
    private Integer id;

    @Column(name = "std_name", nullable = false)
    private String name;

    private int grade;

    @ManyToMany
    @JoinTable(name = "student08_course",
               joinColumns = {@JoinColumn(name = "std_id")},
               inverseJoinColumns = {@JoinColumn(name = "couse_id")})//OPSİYONEL
    private List<Course> courseList=new ArrayList<>();

    public Student08(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student08() {
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
