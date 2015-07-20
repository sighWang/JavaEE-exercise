package com.tw.core;

import com.tw.core.model.Course;
import com.tw.core.model.Customer;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xim on 7/20/15.
 */
public class ManyToManyTest {
    @Test
    public void insert(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        transaction.begin();
        Customer customer = new Customer();
        customer.setName("梅超风");

        Course course = new Course();
        course.setName("拳击");
        Set<Customer> customers  = new HashSet<Customer>();
        customers.add(customer);
        course.setCustomers(customers);
        session.save(customer);
        session.save(course);
        transaction.commit();
        session.close();

    }
}
