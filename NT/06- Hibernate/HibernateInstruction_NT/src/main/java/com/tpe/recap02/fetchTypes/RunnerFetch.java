package com.tpe.recap02.fetchTypes;

import com.tpe.recap02.fetchTypes.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class);
        SessionFactory sf= config.buildSessionFactory();
        Session session = sf.openSession();
        //şu anda bir update(insert delete update) durumu gerçekleşmiyor bundan dolayı transaction başlatılmadı
        // Course course=session.get(Course.class,11);
        //System.out.println(course);//bu kursu veren instructor'da sorgulanır mı(kendim yönetmek istesem?)? evet(hayıra cevirmek istersem) --Eager idi biz lazy'e dondurduk!!!
        //System.out.println(course.getInstructor());//yani daha sorgulanmamış bir bilgiyi java tarafından istersem

        Instructor instructor=session.get(Instructor.class,1);//eager oldugunda tek seferde gerçeklesir
        //System.out.println(instructor);//bu instructorin verdiği kurslar'da sorgulanır mı? Hayır
        //instructor.getCourses().forEach(System.out::println);
        Transaction trs= session.beginTransaction();

        //session.delete(course);
        //Course course=session.get(Course.class,15);
        //course.setInstructor(null);
        //session.saveOrUpdate(course);

        //orphanRemoval
        instructor.getCourses().remove(0);
        //session.saveOrUpdate(instructor);
        System.out.println(instructor.getCourses());

        trs.commit();
        session.close();
        sf.close();

    }
}
