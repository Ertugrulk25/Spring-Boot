package com.tpe.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
/*
        //id 101 olan kıtabi getirelim
        Book book=session.get(Book.class,101);
        System.out.println(book);
*/
        //yukarıdaki kitabın kime ait oldugunu nasıl bulurum --> method yok hql/sql ile yapabiliriz
        //ÖDEV


        //id 1001 olan ogrenciyi getirelim
        Student06 student= session.get(Student06.class,1001);
        System.out.println(student);
        System.out.println(student.getBookList());
/*
        System.out.println("---------------Ogrencinin sahip oldugu kitaplar-------------------");
        System.out.println(student.getBookList());
*/
        //ben öğrenci bilgisini sorguladıgım zaman sadece ogrenci bilgileri sorgulanırken
        //ogrencinin sahip oldugu kitapları getir dedigim zaman bizim icin 2. bir sorgu olusturarak kitap bilgilerine erisildi

        //name:'Jack' olan ogrencinin kıtaplarını getirelim
        //hem student name hemde book bilgilerini ulaşabilmem lazım
 /*       String sql="select b.id,b.name from t_book b  join t_student06_t_book sb on sb.booklist_id=b.id join t_student06 s on s.id=sb.student06_id where s.std_name='Jack'";
        List<Object[]>resultList=session.createSQLQuery(sql).getResultList();
        for (Object[]s:resultList
             ) {
            System.out.println(Arrays.toString(s));
        }
        String sql2="select b.id,b.name from t_book b inner join t_student06 s on b.std_id=s.id where 'Jack'";
*/
        trs.commit();
        session.close();
        sessionFactory.close();

    }}
