package com.usermanagement.model;

import com.usermanagement.dto.LoginDto;

import java.sql.*;

public class LoginDao {

    public boolean validate(LoginDto loginDto) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/?user=root", "root", "admin");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from user_management.user_details where username = ? and password = ? ")) {

            preparedStatement.setString(1, loginDto.userName);
            preparedStatement.setString(2, loginDto.password);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            status = rs.next();
            System.out.println(preparedStatement);

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

}
