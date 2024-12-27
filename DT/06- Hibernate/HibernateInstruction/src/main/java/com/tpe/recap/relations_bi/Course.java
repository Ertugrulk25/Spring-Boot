package com.tpe.recap.relations_bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "r2_course")
public class Course {//many

    @Id
    private Integer id;

    @Column(unique = true)
    private String name;

    private Integer credit;

    @ManyToOne//bu kurs kim tarafından veriliyor
    private Instructor instructor;//pk sütunundaki id değeri kimlik olarak kullanılır

    @ManyToMany(mappedBy = "courses")
    private List<Student> studentList=new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String name, Integer credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
