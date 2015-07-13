package com.tw.core;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Dao {
    private Connection connection = null;
    Session session = null;

    public List<User> getUsers() {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From User";
        List<User> users = session.createQuery(hql).list();
        session.close();

        return users;
    }

    public void deleteUser(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(int id) {
        String sql = "SELECT * from users WHERE id = ?";
        connection = DbUtil.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("sex"), resultSet.getString("email"), resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int updateUser(User user) {
        String sql = "UPDATE users SET name = ?, sex = ?, email = ?, age = ? WHERE  id = ?";
        connection = DbUtil.getConnection();
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSex());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, user.getId());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void addUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
