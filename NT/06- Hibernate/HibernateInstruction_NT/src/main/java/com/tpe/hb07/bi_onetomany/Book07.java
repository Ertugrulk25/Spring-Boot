package com.tpe.hb07.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {//MANY
    @Id
    private Integer id;

    private String name;

    @ManyToOne//FK burada olsun isteriz
    //@JoinColumn//--> OPSİYONEL
    //kullanmazsam JOİNTABLE olur
    private Student07 student;//one

    //const
    public Book07(Integer id, String name, Student07 student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public Book07() {
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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
