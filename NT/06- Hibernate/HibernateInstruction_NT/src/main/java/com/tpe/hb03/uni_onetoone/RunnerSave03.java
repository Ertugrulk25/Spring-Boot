package com.tpe.hb03.uni_onetoone;

import com.tpe.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Student03 student1=new Student03(1001,"Ali",99);
        Student03 student2=new Student03(1002,"Veli",98);
        Student03 student3=new Student03(1003,"Ayşe",97);

        Diary diary1=new Diary(11,"X");
        Diary diary2=new Diary(22,"Y");
        Diary diary3=new Diary(33,"Z");

        /**-------------------------------------*/
        //diary1 ile student1 ilişkilendirelim
        diary1.setStudent(student1);
        diary2.setStudent(student2);
        diary3.setStudent(student3);


        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        trs.commit();
        session.close();
        sessionFactory.close();



    }
}
