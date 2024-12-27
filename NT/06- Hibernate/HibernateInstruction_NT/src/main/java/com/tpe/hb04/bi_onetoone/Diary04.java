package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
public class Diary04 {
    @Id
    private Integer id;

    @Column(name = "diary_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "std_id")
    private Student04 student;

    public Diary04(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Diary04() {
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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
