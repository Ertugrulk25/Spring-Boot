package com.tpe.recap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerCaching {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(RStudent.class).addAnnotatedClass(RBook.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        System.out.println("student 1001 1. kez---------------------------------------------------");
        RStudent student=session.get(RStudent.class,1001);//persisted/managed

        //session.clear();//cache i temizler
        //session.evict(student);//nesneyi detach eder, cacheden çıkarır

        System.out.println("student 1001 2. kez---------------------------------------------------");
        RStudent student2=session.get(RStudent.class,1001);//persisted/managed

        session.close();//first level cache temizlenir

        Session session2=sessionFactory.openSession();

        //second level cacheden gelir
        System.out.println("student 1001 3. kez---------------------------------------------------");
        RStudent student3=session2.get(RStudent.class,1001);//persisted/managed

        session2.close();
        sessionFactory.close();


    }
}
