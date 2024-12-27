package com.tpe.recap.relations_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "r_student")
public class Student {//Many
    @Id
    @GeneratedValue(generator = "seq_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_generator",sequenceName = "seq_std",initialValue = 10000,allocationSize = 3)
    private Integer id;

    @Column(name = "student_name",nullable = false,length = 50)
    private String name;

    @Transient//bu field icin sutun olusturma
    private int bonus;

    private Integer grade;

    @ManyToMany//3. bir tablo olusur
    @JoinTable(name = "std_course",joinColumns = {@JoinColumn(name = "std_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course>courses=new HashSet<>();

    public Student() {
    }

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
