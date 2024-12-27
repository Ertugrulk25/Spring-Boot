package com.tpe.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student09")
public class Student09 {//one

    @Id
    private Integer id;

    @Column(name = "std_name",nullable = false,unique = true,length = 50)
    private String name;

    private int grade;
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)//ilişki karşı tarafta kurulsun ve takip edilsin
    private List<Book09>bookList=new ArrayList<>();

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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
