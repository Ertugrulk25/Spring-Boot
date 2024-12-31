package com.tpe.recap02.fetchTypes;

import com.tpe.recap02.fetchTypes.Course;
import com.tpe.recap02.fetchTypes.Instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {


        //Course Objeleri

        Course course1 = new Course(11, "Hibernate", 4);
        Course course2 = new Course(12, "Advanced Java", 5);
        Course course3 = new Course(13, "Spring Boot", 3);
        Course course4 = new Course(14, "JDBC", 3);
        Course course5 = new Course(15, "SQL", 5);


        ///Instructor Objeleri
        Instructor instructor1 = new Instructor();
        instructor1.setName("Mahmut");

        Instructor instructor2 = new Instructor();
        instructor2.setName("Ekrem");

        Instructor instructor3 = new Instructor();
        instructor3.setName("Semra");

         Instructor instructor4 = new Instructor();
        instructor4.setName("Avni");

        Instructor instructor5 = new Instructor();
        instructor5.setName("Akil");

        //ilişki kuralım


        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);
//        course4.setInstructor(instructor4);//bir tane null deger bulunsun
        course5.setInstructor(instructor1);

        instructor1.getCourses().add(course1);
        instructor1.getCourses().add(course5);
        instructor2.getCourses().add(course2);
        instructor3.getCourses().add(course3);

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class);
        SessionFactory sf= config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trs= session.beginTransaction();

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



        trs.commit();
        session.close();
        sf.close();
    }
}
