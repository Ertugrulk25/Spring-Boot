package com.tpe.recap.relations_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {

        //Student Objeleri

        Student student1 = new Student("Ali",88);
        Student student2 = new Student("Ferit",75);
        Student student3 = new Student("Şaban",89);
        Student student4 = new Student("İsmail",77);
        Student student5 = new Student("Necmi",99);

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
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);

        student2.getCourses().add(course2);
        student2.getCourses().add(course3);

        student3.getCourses().add(course4);

        student4.getCourses().add(course3);
        student4.getCourses().add(course1);


        course1.setInstructor(instructor1);
        course2.setInstructor(instructor1);
        course3.setInstructor(instructor3);
        course4.setInstructor(instructor4);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Instructor.class);
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

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);




        transaction.commit();
        session.close();
        sf.close();


    }
}
