package com.tw.core.dao;

import com.tw.core.model.Coach;
import com.tw.core.model.Customer;
import com.tw.core.model.Employee;
import com.tw.core.model.User;
import com.tw.core.util.HibernateUtil;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.xml.bind.SchemaOutputResolver;
import java.net.SocketPermission;
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

    public void testOneToOne() {
        session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = new Employee(1112, "test", "nan", "ops");
        User user = new User("testUser", "nan", employee);
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(user);
        transaction.commit();
        session.close();
        System.out.printf("testOneByOne");
    }

    public void testManyToOne() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Coach coach =  new Coach(1113, "ManyToOne", "ManyToOne", "Coach");
//        Customer customer = new Customer(11, "Customer", "nan", coach);
//        Transaction transaction = session.beginTransaction();
//        session.save(coach);
//        session.save(customer);
//        transaction.commit();
//        session.close();
    }

    public void findOneToOne() {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.load(User.class, 2);
        System.out.println(user.getName() + "-------------------------------------" + user.getEmployee().getName());
    }
}
