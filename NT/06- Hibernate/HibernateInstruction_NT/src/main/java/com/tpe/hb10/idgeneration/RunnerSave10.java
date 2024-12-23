package com.tpe.hb10.idgeneration;

import com.tpe.hb09.fetchtypes.Book09;
import com.tpe.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {


        Student10 student1=new Student10();
       // student1.setId(1001);
        student1.setName("Jackie jack");
        student1.setGrade(99);

        Student10 student2=new Student10();
       // student2.setId(1002);
        student2.setName("Fred Çakmaktaş");
        student2.setGrade(97);

        Student10 student3=new Student10();
       // student3.setId(1002);
        student3.setName("Barnie");
        student3.setGrade(95);

        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student10.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
        //1001,1002,1003,,,,,,1009,1010
        //1011,1012,1013
        session.save(student3);



        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
