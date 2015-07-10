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
                User user = new User(resultSet.getString("name"), resultSet.getString("sex"),
                        resultSet.getString("email"), resultSet.getInt("age"));
                users.add(user);
                System.out.println(user.getName());

            }

            resultSet.close();
            preparedStatement.close();
            DbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
