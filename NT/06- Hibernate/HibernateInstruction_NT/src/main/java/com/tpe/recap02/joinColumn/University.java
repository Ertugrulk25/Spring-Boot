package com.tpe.recap02.joinColumn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "a_university")
public class University {//one
    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToMany //(mappedBy = "university")kullanamam çünkü ilişki tek taraflı//3.tablo olusur
    @JoinColumn(name = "university_id")//DB'deki student tablosuna fk ekledim
    private List<Student>studentList=new ArrayList<>();

    public University(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public University() {

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
