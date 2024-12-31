package com.tpe.recap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave2 {

    public static void main(String[] args) {

        //Course Objeleri

        RCourse course1 = new RCourse(11, "Hibernate", 4);
        RCourse course2 = new RCourse(12, "Advanced Java", 5);
        RCourse course3 = new RCourse(13, "Spring Boot", 3);
        RCourse course4 = new RCourse(14, "JDBC", 3);
        RCourse course5 = new RCourse(15, "SQL", 5);


        ///Instructor Objeleri
        RInstructor instructor1 = new RInstructor();
        instructor1.setName("Mahmut");

        RInstructor instructor2 = new RInstructor();
        instructor2.setName("Ekrem");

        RInstructor instructor3 = new RInstructor();
        instructor3.setName("Semra");

        RInstructor instructor4 = new RInstructor();
        instructor4.setName("Avni");

        RInstructor instructor5 = new RInstructor();
        instructor5.setName("Akil");

        //ilişkileri kuralım
        course1.setInstructor(instructor1);
        course2.setInstructor(instructor1);
        course3.setInstructor(instructor2);
        course4.setInstructor(instructor3);
        course5.setInstructor(instructor4);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(RCourse.class).
                addAnnotatedClass(RInstructor.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(instructor1);
        session.save(instructor2);
        session.save(instructor3);
        session.save(instructor4);
        session.save(instructor5);


        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(course5);



        transaction.commit();
        session.close();
        sf.close();




    }



}
