package com.tpe.recap.relations_bi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class RunnerFetch {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Instructor.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        Student student=session.get(Student.class,100);
        System.out.println(student);
        System.out.println(student.getCourses());

        System.out.println("------------------------------------------------------------");


        Course course=session.get(Course.class,11);
        System.out.println(course);
//        //course.getStudentList();
//        //sql veya hql
//        List<Student> coursesStudentList=session.
//                createQuery("SELECT s FROM Student s JOIN s.courses c WHERE c.id=11", Student.class).
//                getResultList();
//        coursesStudentList.forEach(t-> System.out.println(t));
        System.out.println(course.getStudentList());//çift yönlü ilişki sayesinde
        //hql veya sql e gerek kalmadı.

        System.out.println(course.getInstructor());
//
//
        System.out.println("------------------------------------------------------------");

        Instructor instructor=session.get(Instructor.class,1);
        //instructor.getCourses();
//        List<Course> courses=session.
//                createQuery("SELECT c FROM Course c JOIN Instructor i ON c.instructor.id=i.id WHERE i.id=1", Course.class).
//                getResultList();
//        courses.forEach(c-> System.out.println(c));

        System.out.println(instructor.getCourseList());


        transaction.commit();
        session.close();
        sf.close();
    }

}
