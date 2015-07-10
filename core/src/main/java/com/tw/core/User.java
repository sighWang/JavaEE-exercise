package com.tw.core;

public class User {
    private String name;
    private String sex;
    private String email;
    private int age;

    public User(String name, String sex, String email, int age) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
