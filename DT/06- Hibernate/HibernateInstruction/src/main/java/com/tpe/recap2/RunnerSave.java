package com.tpe.recap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        RStudent student1 = new RStudent(1001,"Ali",70);
        RStudent student2 = new RStudent(1002,"Veli",70);
        RStudent student3 = new RStudent(1003,"Can",70);
        RStudent student4 = new RStudent(1004,"Deniz",70);


        RBook book1=new RBook(11,"A Book");
        RBook book2=new RBook(22,"B Book");
        RBook book3=new RBook(33,"C Book");
        RBook book4=new RBook(44,"D Book");
        RBook book5=new RBook(55,"E Book");

        //ilişkinin kurulması için
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        //cascadeType:ALL ilişkinin sahibi olmayan tarafta
        student1.getBookList().add(book1);//mappedBy
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);



        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(RStudent.class).addAnnotatedClass(RBook.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
