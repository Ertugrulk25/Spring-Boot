package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepository {

    private Session session;

    //9-c
    public void save(Guest guest) {
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            session.saveOrUpdate(guest);//1,Ali,...

            transaction.commit();
        }catch (Exception e){
             e.printStackTrace();
        }finally {
             HibernateUtils.closeSession(session);
        }
    }

    //ödev2:c
    public Guest findById(Long guestId) {
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            return session.get(Guest.class,guestId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}
