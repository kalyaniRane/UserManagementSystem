package com.usermanagement.model;

import com.usermanagement.dto.LoginDto;
import com.usermanagement.dto.NewUserDto;
import com.usermanagement.dto.UserDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UserDao {
    Connection connection = new DatabaseConnection().getConnection();

    public boolean validate(LoginDto loginDto) throws ClassNotFoundException {
        boolean status = false;

        try (

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from user_management.user_details where username = ? and password = ? ")) {

            preparedStatement.setString(1, loginDto.userName);
            preparedStatement.setString(2, loginDto.password);

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;

    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public UserDto getUserDetailByEmail(String email) {

        String validQuery="select Id,first_name,email,password from user_management.user_details where email=? ";

        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(validQuery)) {

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                UserDto userDto=new UserDto(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));

                return userDto;
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return null;
    }

    public UserDto getUserDetailsByUserName(String userName) {

        String validQuery="select id from user_details where username=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(validQuery);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserDto user = new UserDto();
                user.setId(Long.valueOf(resultSet.getString(1)));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addUser(NewUserDto newUser) {

        String addUserQuery = "insert into `user_details` (`first_name`, `middle_name`, `last_name`, `date_of_birth`, `gender`, " +
                "`country`, `country_code`, `phone_number`, `user_profile_image`, `email`, `address` , `username`, `password`," +
                "`user_role`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(addUserQuery);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getMiddleName());
            preparedStatement.setString(3, newUser.getLastName());
            preparedStatement.setString(4, newUser.getDateOfBirth());
            preparedStatement.setString(5, newUser.getGender());
            preparedStatement.setString(6, newUser.getCountry());
            preparedStatement.setString(7, newUser.getCountryCode());
            preparedStatement.setString(8, String.valueOf(newUser.getMobileNumber()));
            preparedStatement.setBlob(9,newUser.getUserImage());
            preparedStatement.setString(10, newUser.getEmailId());
            preparedStatement.setString(11, newUser.getAddress());
            preparedStatement.setString(12, newUser.getUserName());
            preparedStatement.setString(13, newUser.getPassword());
            preparedStatement.setString(14, newUser.getUserRole());
            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
