package com.tw.core.dao;

import com.tw.core.model.Course;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xim on 7/21/15.
 */

@Repository
public class CourseDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List getCourses() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Course";
        List<Course> courses = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return courses;
    }
}
