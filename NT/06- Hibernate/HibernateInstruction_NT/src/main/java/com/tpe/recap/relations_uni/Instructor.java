package com.tpe.recap.relations_uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_instructor")
public class Instructor {//one

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    //@OneToMany//3. bir tablo:join table
    //@JoinColumn//karşı tabloya fk ekler
    //private List<Course>courses=new ArrayList<>();//gerek var mı?

    public Integer getId() {
        return id;
    }
/*
    public void setId(Integer id) {
        this.id = id;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
*/
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
