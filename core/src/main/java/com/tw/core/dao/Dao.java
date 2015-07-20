package com.tw.core.dao;

import com.tw.core.model.*;
import com.tw.core.util.HibernateUtil;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.xml.bind.SchemaOutputResolver;
import java.net.SocketPermission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void testOneToOne() {
        session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = new Employee(11132, "test", "nan", "ops");
        User user = new User("testUser", "nan", employee);
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(user);
        transaction.commit();
        session.close();
        System.out.printf("testOneByOne");
    }

    public void testManyToOne() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("梅超风");
        session.save(customer);

//        Course course = new Course();
//        course.setName("拳击");
//        Set<Customer> customers  = new HashSet<Customer>();
//        customers.add(customer);
//        course.setCustomers(customers);
//        session.save(course);
        transaction.commit();
        session.close();

    }

    public void findOneToOne() {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.load(User.class, 2);
        System.out.println(user.getName() + "-------------------------------------" + user.getEmployee().getName());
    }
}
