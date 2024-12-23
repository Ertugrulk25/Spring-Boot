package com.tpe.hb08.manytomany;

import com.tpe.hb07.bi_onetomany.Book07;
import com.tpe.hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student08.class).addAnnotatedClass(Course.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

        //id 1001 olan öğrenciyi getirelim
        Student08 student= session.get(Student08.class,1001);
        System.out.println(student);
        System.out.println(student.getCourseList());


        System.out.println("-------------------------------");
        //id'si 11 olan course görelim
        Course course=session.get(Course.class,11);
        System.out.println(course);
        System.out.println(course.getStudentList());

        trs.commit();
        session.close();
        sessionFactory.close();












        










    }
}
