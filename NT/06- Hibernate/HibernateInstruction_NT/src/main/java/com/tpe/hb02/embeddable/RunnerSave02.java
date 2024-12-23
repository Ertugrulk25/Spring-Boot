package com.tpe.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student1=new Student02(1001,"Ali Can",99);
        Student02 student2=new Student02(1002,"Ali Han",99);
        Student02 student3=new Student02(1003,"Veli Can",99);

        Address address1=new Address("Orange Street","London","UK","1234");
        Address address2=new Address("Apple Street","NewYork","USA","9876");

        student1.setAddress(address1);
        student2.setAddress(address2);
        student3.setAddress(address1);
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student02.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        trs.commit();
        session.close();
        sessionFactory.close();

    }
}
