package com.tpe.recap2;

import com.tpe.hb09.fetchtypes.Book09;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tbl_student")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RStudent {
    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)//default fetchtype:lazy
    private List<RBook> bookList=new ArrayList<>();

    public RStudent() {
    }

    public RStudent(Integer id, String name, int grade) {
        this.id = id;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<RBook> getBookList() {
        return bookList;
    }

    public void setBookList(List<RBook> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
