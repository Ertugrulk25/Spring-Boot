package com.tpe.hb09.fetchtypes;

import com.tpe.hb08.manytomany.Course;
import com.tpe.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 student1=new Student09();
        Student09 student2=new Student09();
        Student09 student3=new Student09();
        Student09 student4=new Student09();

        student1.setId(1001);
        student1.setName("Ali Can");
        student1.setGrade(99);

        student2.setId(1002);
        student2.setName("Veli Han");
        student2.setGrade(97);

        student3.setId(1003);
        student3.setName("Ayşe Can");
        student3.setGrade(95);

        student4.setId(1004);
        student4.setName("Ömer Faruk");
        student4.setGrade(98);

        Book09 book1=new Book09();
        book1.setId(11);
        book1.setName("A Book");

        Book09 book2=new Book09();
        book2.setId(22);
        book2.setName("B Book");

        Book09 book3=new Book09();
        book3.setId(33);
        book3.setName("C Book");

        Book09 book4=new Book09();
        book4.setId(44);
        book4.setName("D Book");

        Book09 book5=new Book09();
        book5.setId(55);
        book5.setName("E Book");

        //ilişki kurulmasi için book tarafından set edilmeli
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student3);
        book5.setStudent(student3);

        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        //CascadeType.ALL
        session.save(student4);


        trs.commit();
        session.close();
        sessionFactory.close();


    }
}
