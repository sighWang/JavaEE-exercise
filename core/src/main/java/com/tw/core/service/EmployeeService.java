package com.tw.core.service;

import com.tw.core.dao.EmployeeDao;
import com.tw.core.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xim on 7/21/15.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public Object getEmployees() {
        return employeeDao.getEmployees();
    }
}
