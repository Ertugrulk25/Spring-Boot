package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Room,Guest ve Reservation için service ve repo classlarını oluşturalım:ÖDEV
public class HotelRepository {

    private Session session;


    //1-b:
    public void save(Hotel hotel){
        try {

            session = HibernateUtils.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(hotel);//insert into t_hotel values
            t.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }

    }

}
