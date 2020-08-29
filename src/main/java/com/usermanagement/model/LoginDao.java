package com.usermanagement.model;

import com.usermanagement.dto.LoginDto;
import com.usermanagement.dto.UserDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class LoginDao {

    public boolean validate(LoginDto loginDto) throws ClassNotFoundException {
        boolean status = false;
        Connection connection = getConnection();

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

    public UserDto getUserDetailByEmail(String email) throws ClassNotFoundException {

        Connection connection = getConnection();
        String validQuery="select Id,first_name,email,password from user_management.user_details where email=? ";

        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(validQuery)) {

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                UserDto userDto=new UserDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));

                return userDto;
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return null;
    }

    public Connection getConnection(){
        try {
            FileReader fileReader= new FileReader("D:\\Servelet\\UserManagementSystem\\src\\main\\webapp\\WEB-INF\\database.properties");
            Properties properties=new Properties();
            properties.load(fileReader);
            Class.forName(properties.getProperty("driverClassName"));
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"),
                    properties.getProperty("password"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
