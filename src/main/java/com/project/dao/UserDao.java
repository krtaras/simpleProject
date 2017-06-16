package com.project.dao;

import com.project.entity.Reminder;
import com.project.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum UserDao {
    INSTANCE;

    public int saveUser(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into user (name, surname, phoneNumber, password, login) values (" +
                "?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLogin());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User where User.userId=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            user = getUserByResultSet(preparedStatement);
           } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Reminder> getAllRemindersByUserId(User user) {
        List<Reminder> listOfReminders = new ArrayList<Reminder>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from Reminder where userId=" + user.getUserId();
        try {
            resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Reminder reminder = new Reminder();
                reminder.setStatus(resultSet.getInt("state"));
                reminder.setText(resultSet.getString("text"));
                reminder.setReminderId(resultSet.getInt("reminderId"));
                listOfReminders.add(reminder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfReminders;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User WHERE login = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            user = getUserByResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserByResultSet(PreparedStatement preparedStatement) {
        User user = new User();
        user.setAuthorisedStatus(false);
        ResultSet resultSet;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                user.addReminder(getAllRemindersByUserId(user));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
