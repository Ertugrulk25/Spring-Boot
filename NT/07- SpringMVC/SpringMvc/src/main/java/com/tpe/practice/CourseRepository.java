package com.tpe.practice;

import com.tpe.domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public List<Course> getAllCourses() {
        session = sessionFactory.openSession();
        List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
        session.close();
        return courses;
    }

    public Course getCourseById(Long id) {
        session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public void saveCourse(Course course) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(course);
        transaction.commit();
        session.close();
    }

    public void deleteCourse(Long id) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Course course = session.get(Course.class, id);
        if (course != null) {
            session.delete(course);
        }
        transaction.commit();
        session.close();
    }
}
