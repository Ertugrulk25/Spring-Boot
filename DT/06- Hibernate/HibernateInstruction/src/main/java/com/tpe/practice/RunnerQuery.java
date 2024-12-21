package com.tpe.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/*        TASK 3:id:100 olan öğrenciyi ve kurs listesini getirin
                TASK 4:id:11 olan kursu ve öğrenci listesini getirin
                TASK 5:id:1 olan instructorı getirin
                TASK 6:HQL sorguları çalıştırın:*/
public class RunnerQuery {
    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Instructor.class);

        SessionFactory sf =configuration.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction =session.beginTransaction();


        //TASK 3:id:100 olan öğrenciyi ve kurs listesini getirin
        Student student=session.get(Student.class,100);//courselar da, instructor da gelir
        System.out.println(student);//MS-MC:fetchtype:EAGER
        System.out.println(student.getCourses());//MC-1I:fechtype:default:EAGER
        System.out.println("----------------------------------------------------------------");

        //TASK 4:id:11 olan kursu ve öğrenci listesini getirin
        Course course=session.get(Course.class,11);
        System.out.println(course);
        System.out.println(course.getStudentList());
        System.out.println("----------------------------------------------------------------");


        // TASK 5:id:3 olan instructorı getirin
        Instructor instructor=session.get(Instructor.class,3);
        System.out.println(instructor);

        //TASK 6:HQL sorguları çalıştırın:
        //1. Tüm Öğrencilerin Adlarını ve Notlarını Listeleme
        System.out.println("----------------------------------------------------------------");
        String hql="SELECT s.name,s.grade FROM Student s";
        List<Object[]> students=session.createQuery(hql).getResultList();
        students.forEach(t-> System.out.println(Arrays.toString(t)));

        //2. Advanced Java Kursuna Kaydolan Öğrencilerin(adv java kursunun listesindeki öğrenciler) Adlarını Listeleme
        System.out.println("----------------------------------------------------------------");
        String hql2="SELECT s.name FROM Course c JOIN c.studentList s WHERE c.name='Advanced Java'";
        List<String> names=session.createQuery(hql2).getResultList();
        names.forEach(t-> System.out.println(t));

        // 3. Ali'nin Aldığı Kursların İsimlerini Listeleme:ÖDEV




        transaction.commit();
        session.close();
        sf.close();


    }
}
