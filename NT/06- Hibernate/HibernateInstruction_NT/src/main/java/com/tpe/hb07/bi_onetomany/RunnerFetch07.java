package com.tpe.hb07.bi_onetomany;

import com.tpe.hb06.onetomany.Book;
import com.tpe.hb06.onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();
/*
        //id'si 101 olan kıtabi getirelim
        Book07 book=session.get(Book07.class,101);
       // System.out.println(book);
       // System.out.println(book.getStudent());
/*
        //id'si 1003 öğrenciye erişmek istersem
        Student07 student=session.get(Student07.class,1003);
        System.out.println(student);

        //yukarıdaki öğrencinin kıtap bilgilerini cagırın
        System.out.println(student.getBookList());
/*
        //book07 tablosundaki tüm kıtapları silelim
        String hql="delete from Book07";
        int deletedBooks=session.createQuery(hql).executeUpdate();
        System.out.println("Silinen kitap sayısı : "+deletedBooks);
        System.out.println(student.getBookList());
/*
       //student07 tablosundaki verileri silelim
        String hql2="delete from Student07";
        int deleteStudents=session.createQuery(hql2).executeUpdate();
        System.out.println("silinen öğrenci sayisi : "+deleteStudents);

*/


/*
        //ismi Sefiller olan kıtabı hql ile silelim
        String hql3="Delete from Book07 b where b.name='Sefiller'";
        int numDeletedBook=session.createQuery(hql3).executeUpdate();
        System.out.println("silinen satır sayisi : "+numDeletedBook);

        //id'si 1002 olan öğrenciyi silelim
        Student07 student2=session.get(Student07.class,1002);
        session.delete(student2);
*/
        //kitap bilgisi olan bir öğrenci silmek istersek
        //1.Yol ) bunun için öğrencinin sahip olduğu kitapları silmemiz gerekir
        //2.Yol ) cascade yapısını eklemek

        //idsi 1001 olan öğrencinin kitap listesinden bir kıtabi silelim
        Student07 student3=session.get(Student07.class,1001);
        student3.getBookList().remove(0);


        trs.commit();
        session.close();
        sessionFactory.close();
    }
}
