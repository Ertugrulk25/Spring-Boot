package com.tpe.recap.relations_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).
                addAnnotatedClass(Student.class);
        SessionFactory sf= config.buildSessionFactory();
        Session session = sf.openSession();
        //      Transaction trs= session.beginTransaction();
        Student student=session.get(Student.class,10000);
        System.out.println(student);
        System.out.println(student.getCourses());
        // for (Course c : student.getCourses()
        // ) {
        //     System.out.println(c.getInstructor());
        // }
/*
        Course course=session.get(Course.class,11);
        System.out.println(course);
        course.getStudentList().forEach(System.out::println);
        ////sql ya da hql
        //List<Student>list= session.createQuery("select s from Student s join s.courses c where c.id=11",Student.class).getResultList();
        //System.out.println(list);
        //System.out.println(course.getInstructor());
*/
        System.out.println("---------------------------------------------");
        Instructor instructor=session.get(Instructor.class,1);
        instructor.getCourseList().forEach(System.out::println);//çift yonlü ilişki sağladı
        //sql ya da hql sorgusu ile
       //List<Course>courseList=session.createQuery("select c from Course c join c.instructor i where i.id=1", Course.class).getResultList();
       //courseList.forEach(System.out::println);




        //    trs.commit();
        session.close();
        sf.close();
    }
}
