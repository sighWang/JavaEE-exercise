package com.tw.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xim on 7/17/15.
 */
@Entity
@Table(name = "employee")
public class Coach extends Employee{
    public Coach(){
        super();
    }

    public Coach(String name, String gender, String role) {
        super(name, gender, role);
    }

    public Coach(int id, String name, String gender, String role) {
        super(id, name, gender, role);
    }
}
