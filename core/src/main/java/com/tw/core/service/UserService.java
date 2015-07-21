package com.tw.core.service;

import com.tw.core.dao.UserDao;
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
    public UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void addUser(User user) {
        userDao.addUser(user);

    }

    public User login(String name) {
        return userDao.login(name);
    }

    public void testOneToOne() {
        userDao.testManyToOne();
    }
}