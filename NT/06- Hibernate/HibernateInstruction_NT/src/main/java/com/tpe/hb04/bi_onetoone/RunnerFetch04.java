package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student04.class)//hibernate.cfg.xml
                .addAnnotatedClass(Diary04.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //id : 1001 olan öğrenciyi getirelim
        Student04 student=session.get(Student04.class,1001);
        System.out.println(student);

        System.out.println("========================");
        //id: 1001 olan ogrencinin günlüğünü getirin
        System.out.println(student.getDiary());

        System.out.println("=========================");

        //id: 88 olan günlüğü getirelim
        Diary04 diary=session.get(Diary04.class,88);
        System.out.println(diary);
        System.out.println("===========================");
        //idsi : 88 olan günlüğün sahibinin bilgilerini getirin
        System.out.println(diary.getStudent());
/*
        //idsi 1003 : olan öğrencinin günlüğünü getiriniz
        Student04 student2 = session.get(Student04.class,1003);
        System.out.println(student2.getDiary());
*/
        //task: Bütün öğrenciler ve varsa bu öğrencilerin günlüklerini getirelim(öğrenci ismi ve günlük ismi)
      String hqlQuery="select s.name,d.name from Student04 s left join fetch Diary04 d ON s.id=d.student";
      List<Object[]>resultList=session.createQuery(hqlQuery).getResultList();
      for (Object[] s:resultList
           ) {
          System.out.println(Arrays.toString(s));
      }


        String hqlQuery2="select s.name,d.name from Student04 s inner join  Diary04 d ON s.id=d.student";
         List<Object[]>resultList2=session.createQuery(hqlQuery2).getResultList();
         for (Object[] s:resultList2
              ) {
             System.out.println(Arrays.toString(s));
         }

    }


}
