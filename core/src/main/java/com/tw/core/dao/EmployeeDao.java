package com.tw.core.dao;

import com.tw.core.model.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by xim on 7/21/15.
 */

@Repository
public class EmployeeDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private List employees;

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
}
