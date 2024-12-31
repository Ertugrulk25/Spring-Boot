package com.tpe.recap02.fetchTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "e_instructor")
public class Instructor {//one

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)//3. bir tablo:join table
    //@JoinColumn//karşı tabloya fk ekler
    private List<Course>courses=new ArrayList<>();//gerek var mı?

    //CascadeType.REMOVE bir intructor silindiginde buna baglı tum degerlerde silinir
    //CascadeType.ALL bir instructor silindiginde buna baglı tum degerlerde silinir
    //CascadeType.MERGE bir instructor kaydedildiginde buna baglı tüm degerler kaydedilir
    //CascadeType.PERSIST
    //CascadeType.REFRESH



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

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
