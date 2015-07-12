package com.tw.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private Connection connection = null;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        connection = DbUtil.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("sex"),
                        resultSet.getString("email"), resultSet.getInt("age"));
                users.add(user);

            }

            resultSet.close();
            preparedStatement.close();
            DbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public int deleteUser(int id) {
        int result = 0;
        String sql = "DELETE from users WHERE id = ?";
        connection = DbUtil.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
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

    public int addUser(String name, String sex, String email, int age) {
        String sql = "INSERT INTO users(name, sex, email, age) VALUES (?, ?, ?, ?)";
        connection = DbUtil.getConnection();
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sex);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, age);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
