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
}