package com.tw.core.dao;

import com.tw.core.model.Schedule;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public void addSchedule(Schedule schedule) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(schedule);
        transaction.commit();
    }
}
