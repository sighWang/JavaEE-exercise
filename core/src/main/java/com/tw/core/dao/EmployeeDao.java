package com.tw.core.dao;

import com.tw.core.model.Employee;
import com.tw.core.model.User;
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
public class EmployeeDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }


    public List getEmployees() {
        Session session = sessionFactory.openSession();
        String hql = "From Employee ";
        List<Employee> employeeList = session.createQuery(hql).list();
        session.close();
        return employeeList;
    }

    public Employee getEmployee(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }
}
