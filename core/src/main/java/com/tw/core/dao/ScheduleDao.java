package com.tw.core.dao;

import com.tw.core.model.Schedule;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addSchedule(Schedule schedule) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(schedule);
        transaction.commit();
    }

    public List<Schedule> getSchedules() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Schedule";
        List<Schedule> schedules = session.createQuery(hql).list();
        transaction.commit();
        return schedules;
    }

    public void deleteSchedule(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Schedule schedule = (Schedule) session.load(Schedule.class, id);
        System.out.printf(schedule.getCourse().getName());
        session.delete(schedule);
        session.getTransaction().commit();
        session.close();
    }

    public Schedule getSchedule(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Schedule schedule = (Schedule) session.load(Schedule.class, id);
        transaction.commit();
        return schedule;
    }
}
