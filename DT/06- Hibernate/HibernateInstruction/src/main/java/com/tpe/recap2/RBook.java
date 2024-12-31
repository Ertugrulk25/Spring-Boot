package com.tpe.recap2;

import com.tpe.hb09.fetchtypes.Student09;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;

@Entity
@Table(name = "tbl_book")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RBook {
    @Id
    private Integer id;
    private String name;

    //cascade = CascadeType.ALL:bir kitabı DB ye kaydettiğimde bu kitabın
    // sahibi olan öğrenciyi de otomatik olarak kaydeder
    @ManyToOne(fetch = FetchType.LAZY)/*(cascade = CascadeType.ALL)*///default fetchtype:eager
    private RStudent student;

    public RBook() {
    }

    public RBook(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public RStudent getStudent() {
        return student;
    }

    public void setStudent(RStudent student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
