package com.tpe.hb06.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {//ONE

    @Id
    private Integer id;

    @Column(name = "std_name",nullable = false)
    private String name;


    private int grade;

    @OneToMany//tablolar arasında ilişki kurar
    @JoinColumn(name = "std_id")//jointable yapmayarak,book tablosuna fk ekler
    //joincolumn kullanmazsam JOİN TABLE oluşur
    private List<Book>bookList=new ArrayList<>();



    //const
    public Student06(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student06() {
    }



    //getter-setter

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
