package com.tpe.hb12.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
1)  First Level Cache --->
            * nesne için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            * nesne için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * first/second level cache ile kullanılabilir
            * aynı sorgunun sonucu cache e alınır.

 */

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student11.class);


        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction trs = session1.beginTransaction();

        System.out.println("---------------------1 idli student icin ilk sorgu");
        Student11 student1=session1.get(Student11.class,1);
        System.out.println(student1);
        System.out.println("-----------------------------");

        //session1.clear();//ön belleği temizler bundan kaynakları tekrar bir sorgu yaptıgımızda DB'e gider

        System.out.println("---------------------1 idli student icin 2. sorgu");
        Student11 student2=session1.get(Student11.class,1);
        System.out.println(student2);

        trs.commit();
        session1.close();

        Session session2=sessionFactory.openSession();//yeni bir Kamyon alıyorum database'den veri getirmesi icin

        System.out.println("---------------------1 idli student icin 3. sorgu");
        Student11 student3=session2.get(Student11.class,1);
        System.out.println(student3);

        session1.close();
        sessionFactory.close();

//SONUÇ:First Level Cache:
//      aynı sessionda aynı objeyi fetch etmek istediğimizde
//      bir kere DB ye başvurur, daha sonra cacheden getirir.
//      session kapatılır veya clear metodu çağrılırsa cache temizlenir
//      dolayısıyla aynı obje için tekrar DB ye başvurulur.

//    Second Level Cache:
//      aynı sessionda aynı objeyi fetch etmek istediğimizde
//      bir kere DB ye başvurur, daha sonra first level cacheden getirir.
//      session kapatılırsa cache temizlenir
//      aynı obje farklı sessionda bu defa second level cacheden gelir.

    }
}
