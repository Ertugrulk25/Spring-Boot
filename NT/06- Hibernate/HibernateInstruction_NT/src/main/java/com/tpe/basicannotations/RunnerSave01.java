package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Ali");
        student1.setSurname("Can");
        student1.setGrade(99);


        Student student2=new Student();
        student2.setId(1002);
        student2.setName("Veli");
        student2.setSurname("Han");
        student2.setGrade(98);

        Student student3=new Student();
        student3.setId(1003);
        student3.setName("Ayşe");
        student3.setSurname("Öz");
        student3.setGrade(97);




//cfg dosyasinin ismini yazıyorduk eğer yazmasanız hata vermez çünkü default olarak icerisine "hibernate.cfg.xml" yazar
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student.class).addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();

        //hibernatede default olarak auto-commit false yani sorgular bekler neyi commit komutunu
        //db de işlemlerin kalıcı olmasi icin transaction başlatıp onaylaması gerekiyor
        Transaction trs= session.beginTransaction();
        //transaction(db'de atomik işlem birimi) başlatılır.

        session.save(student1);
        session.save(student2);
        session.save(student3);

        trs.commit();//gümrük tüm işlemleri onayladı geçiş serbest
        session.close();
        sessionFactory.close();







    }
}














