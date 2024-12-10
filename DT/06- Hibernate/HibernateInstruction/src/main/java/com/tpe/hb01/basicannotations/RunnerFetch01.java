package com.tpe.hb01.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

//uygulamaya veritabanından data çekme
public class RunnerFetch01 {
    public static void main(String[] args) {

/*
DB den data çekmek için:fetch işlemlerinde transactiona gerek yoktur
          Task:id=1001/1002/1003 olan öğrenciyi tüm fieldlarıyla getirmek(fetch) istiyoruz.
           1) sessionın metodu:get():en pratik ama kullanım alanı kısıtlı
           2) SQL : DB ce
           3) HQL(Hibernate Query Language): Javaca

           HQL (Hibernate Query Language), Hibernate ORM tarafından sağlanan,
           nesne odaklı bir sorgulama dilidir. HQL, SQL'e benzer şekilde çalışır
           ancak doğrudan veritabanı tablolarıyla değil,
           Java sınıfları (entity'ler) ve onların özellikleriyle çalışır
*/
        Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //get
        Student student=session.get(Student.class,1001);
        System.out.println("-------------get metodu----------------");
        System.out.println(student);

        //SQL
        String sql="SELECT * FROM t_student WHERE id=1002";
        Object[] student2= (Object[]) session.createSQLQuery(sql).uniqueResult();
        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır
        //geriye bir satırdan birden fazla data geldiği için data tipleri farklı
        //old için Object[] içine alınır.

        System.out.println("-------------SQL----------------");
        System.out.println(Arrays.toString(student2));


        //HQL:Javaca:daha aşinayız
        String hql="FROM Student WHERE id=1003";
        Student student3=session.createQuery(hql, Student.class).uniqueResult();
        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır
        System.out.println("-------------HQL----------------");

        System.out.println(student3);

        //tüm kayıtları çekelim
        //hql ile
        List<Student> studentList=session.createQuery("FROM Student", Student.class).getResultList();
        //getResultList birden fazla kayıt geleceği zaman kullanılır
        System.out.println("Tüm öğrenciler");
        for (Student s:studentList){
            System.out.println(s);
        }

        //sql ile tüm kayıtları çekelim:exercise

        // HQL ile grade degeri 98 olan ogrencilerin id ve name bilgilerini getirelim
        String hql2="SELECT s.id,s.name FROM Student s WHERE s.grade=98";
        List<Object[]> resultList=session.createQuery(hql2).getResultList();
        for (Object[] oa:resultList){
            System.out.println(Arrays.toString(oa));
        }

        //practice:HQL ile
        //1-ismi Harry Potter olan öğrencileri getirelim
        //2-tüm öğrencilerin sadece isimlerini getirelim
        //SQL ile
        //1-tüm öğrencilerin sadece isimlerini getirelim

        session.close();
        sf.close();




    }
}
