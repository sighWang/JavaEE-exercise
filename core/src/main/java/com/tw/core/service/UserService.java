package com.tw.core.service;

import com.tw.core.dao.Dao;
import com.tw.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public String service() {
        return "Hello World";
    }

    @Autowired
    public Dao dao;

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public void updateUser(User user) {
         dao.updateUser(user);
    }

    public void addUser(User user) {
        dao.addUser(user);

    }

    public User login(String name) {
        return dao.login(name);
    }
}