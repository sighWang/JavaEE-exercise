package com.tw.core;

import java.util.List;

public class Service {
    public String service() {
        return "Hello World";
    }

    public Dao dao = new Dao();

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public int deleteUser(int id) {
        return dao.deleteUser(id);
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    public int addUser(String name, String sex, String email, int age) {
        return dao.addUser(name, sex, email, age);

    }
}