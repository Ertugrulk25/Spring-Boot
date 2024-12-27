package com.tpe.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {
        Student12 student1=new Student12("Jack",99);
        Student12 student2=new Student12("Fred",98);
        Student12 student3=new Student12("Barnie",97);


        Configuration config = new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student12.class);


        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

        session.save(student1);
        session.persist(student2);//save:deprecated
        session.persist(student3);//save:deprecated


        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
