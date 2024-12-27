package com.tpe.hb13.entity_life_cycle;

import com.tpe.hb12.get_load.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1=new Student13("Jack",99);//-->transient
        Student13 student2=new Student13("Harry",99);//-->transient



        Configuration config = new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student13.class);


        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

        session.save(student1);//-->persisted/maneged
        student1.setName("Sherlock");//--> sherlock --> jack mi?

        session.evict/*(zorla bir yapıyı ayırmak)*/(student1);//objeyi detach(ayırmak) eder.
        student1.setName("Ahmet");//--> sherlock --> ahmet mi? --> database tarafında işlem görmez

        session.update(student1);//persist hale getirim yani tekrar session ile birliştiririm
        student1.setName("Mehmet");




        trs.commit();
        session.close();
        student1.setName("Ahmet");//detached
        //bunun hala database'de bir karşılığı vardır
        Session session2=sessionFactory.openSession();
        Transaction trs2=session2.beginTransaction();

        session2.update(student1);//persist data base tarafından da yapılsın
        student1.setGrade(999);
        session2.get(Student13.class,1);
        session2.remove(student1);
        //DB deki satırı java objesi ile günceller

        trs2.commit();
        session2.close();
        sessionFactory.close();
    }
}
