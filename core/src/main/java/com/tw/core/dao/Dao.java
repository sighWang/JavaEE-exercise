package com.tw.core.dao;

import com.tw.core.model.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Dao {
    Session session = null;

    public List<User> getUsers() {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From User";
        List<User> users = session.createQuery(hql).list();
        session.close();

        return users;
    }

    public void deleteUser(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        session.close();

        return user;
    }

    public void updateUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void addUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User login(String name) {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from User where name = :name";
        Query query = session.createQuery(hql);
        query.setString("name", name);

        return (User) query.list().get(0);
    }
}
