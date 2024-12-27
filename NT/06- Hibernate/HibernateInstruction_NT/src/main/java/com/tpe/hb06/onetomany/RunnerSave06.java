package com.tpe.hb06.onetomany;

import com.tpe.hb05.manytoone.Student05;
import com.tpe.hb05.manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {
        Student06 student1=new Student06(1001,"Jack",99);
        Student06 student2=new Student06(1002,"Harry",98);
        Student06 student3=new Student06(1003,"Fred",97);

        Book book1=new Book(101,"Sefiller");
        Book book2=new Book(102,"Gazap Üzümleri");
        Book book3=new Book(103,"Suç ve Ceza");
        Book book4=new Book(104,"Tutunamayanlar");
        Book book5=new Book(105,"Anna Karanina 1");

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);

        student3.getBookList().add(book4);
        student3.getBookList().add(book5);

        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);


        session.save(student1);
        session.save(student2);
        session.save(student3);

        trs.commit();
        session.close();
        sessionFactory.close();


    }
}
