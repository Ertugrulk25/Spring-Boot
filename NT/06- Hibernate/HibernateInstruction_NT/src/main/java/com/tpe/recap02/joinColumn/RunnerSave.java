package com.tpe.recap02.joinColumn;

import com.tpe.recap02.joinColumn.Student;
import com.tpe.recap02.joinColumn.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
    Student student1=new Student(1001,"Ayşe Hanım");
    Student student2=new Student(1002,"Ali Bey");
    Student student3=new Student(1003,"Veli Bey");
    Student student4=new Student(1004,"Ömer Bey");

     University university=new University(1,"TechproEducation University");
     university.getStudentList().add(student1);
     university.getStudentList().add(student2);
     university.getStudentList().add(student3);
     university.getStudentList().add(student4);
    Configuration config=new Configuration().configure()//hibernate.cfg.xml
            .addAnnotatedClass(Student.class).addAnnotatedClass(University.class);

    SessionFactory sessionFactory= config.buildSessionFactory();
    Session session=sessionFactory.openSession();
    Transaction trs= session.beginTransaction();
    session.save(university);
    session.save(student1);
    session.save(student2);
    session.save(student3);
    session.save(student4);
    trs.commit();
    session.close();
    sessionFactory.close();
}}
