package com.tw.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public String service() {
        return "Hello World";
    }

    @Autowired
    public Dao dao;// = new Dao();

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    public void addUser(User user) {
        dao.addUser(user);

    }
}