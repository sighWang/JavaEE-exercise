package com.tw.core.service;

import com.tw.core.dao.EmployeeDao;
import com.tw.core.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public List getEmployees() {
        return employeeDao.getEmployees();
    }

    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }
}
