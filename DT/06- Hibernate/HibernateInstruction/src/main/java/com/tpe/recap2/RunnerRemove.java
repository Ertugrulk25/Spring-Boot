package com.tpe.recap2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerRemove {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure().
                addAnnotatedClass(RCourse.class).
                addAnnotatedClass(RInstructor.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

//        RCourse course=session.get(RCourse.class,11);
//        session.delete(course);//child tableda yer alır,

//        RCourse course2=session.get(RCourse.class,12);
//        session.delete(course2);//child tableda yer alır,
//
//        RInstructor instructor=session.get(RInstructor.class,1);
//        session.delete(instructor);//child tabledan ref alındığı için doğrudan silinemez

//        RInstructor instructor2=session.get(RInstructor.class,2);
//        session.delete(instructor2);//child tabledan ref alındığı için doğrudan silinemez

//        RInstructor instructor3=session.get(RInstructor.class,4);
//        session.delete(instructor3);//child tabledan ref alındığı için doğrudan silinemez


        //---------------------------------------------------------------------------------
//        RInstructor instructor1=session.get(RInstructor.class,6);
//        System.out.println(instructor1.getCourses());//id:11,12
//
//        instructor1.getCourses().remove(0);//uygulamada :course id:12
//
//        System.out.println(instructor1.getCourses());//id:12

        RInstructor instructor2=session.get(RInstructor.class,8);
        System.out.println(instructor2.getCourses());//id:13

        instructor2.getCourses().set(0,null);//uygulamada :courses:empty

        System.out.println(instructor2.getCourses());//null


        transaction.commit();
        session.close();
        sf.close();

    }
}
