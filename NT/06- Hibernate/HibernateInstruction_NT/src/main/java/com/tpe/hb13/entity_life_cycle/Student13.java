package com.tpe.hb13.entity_life_cycle;

import javax.persistence.*;

/*

	Entity State :

		1) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.
		 Bu durumda, nesne henüz bir Hibernate session'ına kaydedilmemiştir ve veritabanında bir karşılığı
		yoktur. Geçici durumdaki bir nesne, session'ın kapatılmasıyla birlikte kaybolur.

		2) Persisted or Managed : DB de row a karşılık geldiği durum, save(),get() vs. yapıldığı
		zamana denk geliyor. Bu durumda, nesne bir Hibernate session'ına kaydedilmiştir ve
		veritabanında bir karşılığı vardır. Kalıcı durumdaki bir nesne, session kapatılsa
		bile veritabanında kalır ve daha sonra yeniden kullanılabilir.

		3) Detached :  Bu durumda, nesne bir Hibernate session'ından ayrılmıştır. Artık bu
		session tarafından yönetilmiyor, ancak veritabanında hala bir karşılığı var. Ayrılmış
		durumdaki bir nesne, başka bir session'a bağlanarak kullanılabilir.

		4) Removed : obje remove yapıldığı zamanki durum.
*/

@Entity
public class Student13 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int grade;

    public Student13(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student13() {
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student13{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
    @PrePersist
    public void prePersist(){
        System.out.println("----------------Obje kaydediliyor...");
    }

    @PostPersist
    public void postPersist(){
        System.out.println("----------------Obje Kaydedildi...");
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("----------------Obje Güncelleniyor...");
    }

    @PostUpdate
    public void postUpdate(){
        System.out.println("---------------Obje güncellendi...");
    }
    @PreRemove
    public void preDelete(){
        System.out.println("---------------Obje siliniyor...");
    }
    @PostRemove
    public void postDelete(){
        System.out.println("---------------Obje silindi...");
    }

    @PostLoad
    public void preLoad(){
        System.out.println("---------------Obje yüklendi...");
    }





}
