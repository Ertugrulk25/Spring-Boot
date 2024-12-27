package com.tpe.hb05.manytoone;

import com.tpe.hb04.bi_onetoone.Diary04;
import com.tpe.hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {
      // Student05 student1=new Student05(1001,"Ayşe Hanım",10);
      // Student05 student2=new Student05(1002,"Ali Bey",5);
      // Student05 student3=new Student05(1003,"Veli Bey",15);
        Student05 student4=new Student05(1004,"Ömer Bey",90);

       // University university=new University(1,"TechproEducation University");
       // student1.setUniversity(university);
       // student2.setUniversity(university);
       // student3.setUniversity(university);

        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
      //session.save(university);
      //session.save(student1);
      //session.save(student2);
      //session.save(student3);

       session.save(student4);

        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
