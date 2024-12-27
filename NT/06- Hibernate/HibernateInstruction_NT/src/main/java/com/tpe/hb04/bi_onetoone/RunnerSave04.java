package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {
        Student04 student1=new Student04(1001,"Ayşe Hanım",10);
        Student04 student2=new Student04(1002,"Ali Bey",5);
        Student04 student3=new Student04(1003,"Veli Bey",15);

        Diary04 diary1=new Diary04(99,"Ayşenin günlüğü");
        Diary04 diary2=new Diary04(88,"Alinin günlüğü");
        diary1.setStudent(student1);
        diary2.setStudent(student2);


        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(diary1);
        session.save(diary2);
        trs.commit();
        session.close();
        sessionFactory.close();

    }
}
