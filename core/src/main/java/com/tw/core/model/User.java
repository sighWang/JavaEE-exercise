package com.tw.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private String password;



    public User() {
    }

    public User(String name, String sex, String email, int age, String password) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.age = age;
        this.password = password;

    }

    public User(int id, String name, String sex, String email, int age, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
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
