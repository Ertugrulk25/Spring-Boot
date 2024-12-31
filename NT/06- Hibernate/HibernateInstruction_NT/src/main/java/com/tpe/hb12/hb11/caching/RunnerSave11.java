package com.tpe.hb12.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {

        Student11 student1 = new Student11();
        // student1.setId(1001);
        student1.setName("Jackie jack");
        student1.setGrade(99);

        Student11 student2 = new Student11();
        // student2.setId(1002);
        student2.setName("Fred Çakmaktaş");
        student2.setGrade(97);

        Student11 student3 = new Student11();
        // student3.setId(1002);
        student3.setName("Barnie");
        student3.setGrade(95);

        Student11 student4=new Student11("Rod",98);
        Configuration config = new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student11.class);


        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();
        //1001,1002,1003,,,,,,1009,1010
        //1011,1012,1013
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);


        trs.commit();
        session.close();
        sessionFactory.close();
    }
}