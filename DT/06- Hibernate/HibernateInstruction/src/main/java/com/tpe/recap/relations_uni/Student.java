package com.tpe.recap.relations_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "r_student")
public class Student {

    @Id
    @GeneratedValue(generator = "seq_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_generator",sequenceName = "seq_std",initialValue = 100,allocationSize = 3)
    private Integer id;

    @Column(name = "student_name",nullable = false,length = 50)
    private String name;

    @Transient//bu field için sütun oluşturma
    private int bonus;

    private Integer grade;

    @ManyToMany//tablolar arasındaki ilişkinin kurulmasını sağlar
    @JoinTable(name = "std_course",joinColumns ={@JoinColumn(name = "std_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses=new HashSet<>();

    public Student() {
    }//hibernate fetch işlemlerinde kullanır

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
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
