package com.tpe.hb07.bi_onetomany;

import com.tpe.hb06.onetomany.Book;
import com.tpe.hb06.onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {
        Student07 student1=new Student07(1001,"Jack",99);
        Student07 student2=new Student07(1002,"Harry",98);
        Student07 student3=new Student07(1003,"Fred",97);

        Book07 book1=new Book07(101,"Sefiller",student1);
        Book07 book2=new Book07(102,"Gazap Üzümleri",student1);
        Book07 book3=new Book07(103,"Suç ve Ceza",student2);
        Book07 book4=new Book07(104,"Tutunamayanlar",student3);
        Book07 book5=new Book07(105,"Anna Karanina 1",student3);


        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
      //  session.save(student1);
        session.save(student2);
       // session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
