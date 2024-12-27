package com.tpe.hb07.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {//one -- PARENT

    @Id
    private Integer id;

    @Column(name = "std_name",nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student",/*cascade = CascadeType.REMOVE*/orphanRemoval = true)
    //CascadeType.Remove : parent tablosunda satir silmek istedigimizde
    //önce diğer tablodan ilişkili olduğu satırları(booklist) siler ardından parenttaki veriyi siler


    //orphanRemoval : sadece oneToMany anatasyonunda vardır
    //studentin kitap listesinden bir kıtabi silersek ya da null yaparsak
    //book07 tablosundan silinmesini saglar

    private List<Book07> bookList=new ArrayList<>();//many --CHİLD


    public Student07(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student07() {
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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
