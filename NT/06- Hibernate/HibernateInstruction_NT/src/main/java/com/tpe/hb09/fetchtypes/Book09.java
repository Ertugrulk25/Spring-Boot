package com.tpe.hb09.fetchtypes;

import javax.persistence.*;

@Entity
public class Book09 {//Many ilişki sahibi
    @Id
    private Integer id;

    private String name;

    //bir kitap db'e kaydedildigi zaman bu kitabin sahibi eğer db'de yoksa
    //kitabin sahibide db'e kaydedilir
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Student09 student;

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
