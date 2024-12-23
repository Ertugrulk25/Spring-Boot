package com.tpe.hb09.fetchtypes;

import com.tpe.hb08.manytomany.Course;
import com.tpe.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

OneToMany       --> LAZY
ManyToMany      --> LAZY
OneToOne        --> EAGER
ManyToOne       --> EAGER
*/
public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

       // Student fetch edelim
        Student09 student=session.get(Student09.class,1003);
        System.out.println(student);
        System.out.println(student.getBookList());

        //Book objesi fetch edelim
        Book09 book=session.get(Book09.class,33);
        System.out.println(book);


        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
