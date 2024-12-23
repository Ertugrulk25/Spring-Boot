package com.tpe.hb12.get_load;
/*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı

   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı

 */


import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student12.class);


        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();
/*
        System.out.println("-----------Get methodundan önce");
        Student12 student1=session.get(Student12.class,1);//--ihtiyac duymasına gerek yok direkt sorguyu yapıyor!!!
        System.out.println("-----------Get methodundan sonra");
        System.out.println(student1);
        System.out.println("ID : "+student1.getId());
        System.out.println("Name : "+student1.getName());


        System.out.println("-----------Load Methodundan önce");
        Student12 student2=session.load(Student12.class,1);//-- ihtiyac duyulmadan db'den bilgi getirmiyor!!!
        System.out.println("-----------Load Methodundan sonra");
        System.out.println("ID : "+student2.getId());
        System.out.println("Name : "+student2.getName());
*/
/*
        Student12 student=session.get(Student12.class,10);
        System.out.println(student);
*/
        /*
        Student12 student2=session.load(Student12.class,10);
        System.out.println(student2.getId());
        System.out.println(student2.getName());
*/

        //olmadan bir id ile bir obje getirmek istersem bu yolu tercih ederim!!!
        Student12 student=session.get(Student12.class,10);
        if (student!=null){
            System.out.println(student);
            System.out.println(student.getName());
        }else {
            System.out.println("Bu öğrenci bulunamadı!!!");
        }


        try {
            Student12 student2 = session.load(Student12.class, 11);
            System.out.println(student2);
        }catch (ObjectNotFoundException e){
            System.out.println("Öğrenci Bulunamadı!!!!");
        }

        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
