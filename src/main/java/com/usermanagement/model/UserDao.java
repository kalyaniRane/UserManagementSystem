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

            preparedStatement.setString(1, loginDto.getUserName());
            preparedStatement.setString(2, loginDto.getPassword());

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

        String validQuery="select Id,first_name,password,email from user_management.user_details where email=? ";

        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(validQuery)) {

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                UserDto userDto=new UserDto();
                userDto.setId(rs.getLong(1));
                userDto.setName(rs.getString(2));
                userDto.setEmail(rs.getString(4));
                userDto.setPassword(rs.getString(3));
                return userDto;
            }


        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
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

    public boolean addPermission(Long userId,int permissionId,boolean add,boolean delete,boolean modify,boolean read){

        String addPermissions = "insert into `user_permission` (`user_id`, `permission_id`, `add`, `delete`, `modify`, `read`) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement=connection.prepareStatement(addPermissions);
            preparedStatement.setLong(1,userId);
            preparedStatement.setInt(2,permissionId);
            preparedStatement.setBoolean(3,add);
            preparedStatement.setBoolean(4,delete);
            preparedStatement.setBoolean(5,modify);
            preparedStatement.setBoolean(6,read);
            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
