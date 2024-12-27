package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();



        //id 1001 olan öğrenciyi fetch edelim
        Student05 student05= session.get(Student05.class,1001);
        System.out.println(student05);
        System.out.println(student05.getUniversity());
/*
        //id 1 olan üniversiteyi getirelim
        University university=session.get(University.class,1);
        System.out.println(university);
/*
        //id 1 olan üniversitenin tüm öğrencilerini getirelim
        //HQL SQL
        String hql ="SELECT s From Student05 s where s.university=1";
        List<Student05>resultList =session.createQuery(hql).getResultList();
        for (Student05 s:resultList) {
            System.out.println(s);
        }

        //öğrencilerin isimlerini,notlarını ve
        //üniversitelerinin ismini yazdıralım
        String hql2="Select s.name,s.grade from Student05 s ";
        List<Object[]>resultList2=session.createQuery(hql2).getResultList();
        for (Object[] objects:resultList2) {
            System.out.println(Arrays.toString(objects));
        }

*/








        session.close();
        sessionFactory.close();


    }
}
