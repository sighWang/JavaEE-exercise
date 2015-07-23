package com.tw.core.dao;

import com.tw.core.model.Customer;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Customer> getCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Customer";
        List<Customer> customers = session.createQuery(hql).list();
        transaction.commit();
        return customers;
    }

    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, id);
        transaction.commit();
        return customer;
    }

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
    }

    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
    }
}
