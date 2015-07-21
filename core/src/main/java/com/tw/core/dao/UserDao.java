package com.tw.core.dao;

import com.tw.core.model.*;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDao {
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

    public void testManyToMany() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("用户编号不能重复");
        customer.setNumber(57);
        customer.setGender("nv");
        customer.setId(9);

        Course course = new Course();
        course.setName("拳击课程");
        course.setDescribes("是不是拳击重复了");
        course.setId(9);
        Set<Customer> customers  = new HashSet<Customer>();
        customers.add(customer);
        course.setCustomers(customers);

        session.save(course);
        session.save(customer);

        transaction.commit();
        session.close();
    }

    public void testManyToOne() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("职员");
        employee.setId(9);
        Course course = new Course();
        course.setName("拳击课程");
        course.setEmployee(employee);
        course.setDescribes("是不是拳击重复了");

        Course course1 = new Course();
        course.setName("hahahah");
        course1.setDescribes("hahhahahahhaa");
        course.setEmployee(employee);
        session.save(employee);
        session.save(course);
        transaction.commit();
        session.close();

    }

    public void findManyToMAny() {
        session = HibernateUtil.getSessionFactory().openSession();
        Course course = (Course) session.load(Course.class, 9);
        System.out.printf(((Customer)course.getCustomers().toArray()[0]).getName() + "=============================");

    }

    public void findOneToOne() {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.load(User.class, 2);
        System.out.println(user.getName() + "-------------------------------------" + user.getEmployee().getName());
    }
}
