package com.tpe.recap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchType {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(RStudent.class).addAnnotatedClass(RBook.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();


        //student fetch edelim:LAZY(one-to-many,many-to-many)
        RStudent student=session.get(RStudent.class,1001);
        System.out.println(student.getBookList());//-->yeniden DB ye başvurur

        //book fetch edelim:EAGER(one-to-one,many-to-one)
        //RBook book=session.get(RBook.class,11);
        //System.out.println(book.getStudent());-->yeniden DB ye gitmesine gerek kalmaz

        session.close();
        sessionFactory.close();
       // System.out.println(student.getBookList());//-->DB ye gidemediği için getiremez
        //System.out.println(book.getStudent());//-->yeniden DB ye gitmesine gerek kalmaz

    }
}


















