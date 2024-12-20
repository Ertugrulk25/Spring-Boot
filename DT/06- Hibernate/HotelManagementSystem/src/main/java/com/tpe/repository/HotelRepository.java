package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    //2-c:DB den id verilen satırı getirme
    public Hotel findById(Long id) {

        try {
            session=HibernateUtils.getSessionFactory().openSession();
            //Transaction t=session.beginTransaction();--fetch işlemlerinde gerek yok
            return session.get(Hotel.class,id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //3-c:DB den tablonun tüm kayıtlarını çekme
    public List<Hotel> findAll() {
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("FROM Hotel",Hotel.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}
