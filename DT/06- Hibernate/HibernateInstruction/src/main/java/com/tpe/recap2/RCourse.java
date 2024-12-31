package com.tpe.recap2;

import com.tpe.practice.Instructor;
import com.tpe.practice.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_course")
public class RCourse {//owner of relation
    @Id
    private Integer id;

    @Column(unique = true)
    private String name;

    private Integer credit;

    @ManyToOne
    private RInstructor instructor;

    public RCourse() {
    }

    public RCourse(Integer id, String name, Integer credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
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


    public RInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(RInstructor instructor) {
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
