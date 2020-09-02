package com.usermanagement.model;

import com.usermanagement.dto.LoginDto;
import com.usermanagement.dto.NewUserDto;
import com.usermanagement.dto.UserDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class UserDao {

    Connection connection = new DatabaseConnection().getConnection();

    public boolean validate(LoginDto loginDto) {
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
            e.printStackTrace();
        }
        return status;

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

    public List<UserDto> getAllUserDetails() {
        List<UserDto> userDetails=new ArrayList();

        String getUserDetails="select first_name,middle_name,last_name,email,date_of_birth,user_profile_image,user_role,id from user_details";

        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(getUserDetails);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                UserDto userDto=new UserDto();

                userDto.setName(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
                userDto.setEmail(resultSet.getString(4));
                userDto.setDateOfBirth(resultSet.getString(5));
                userDto.setUserRole(resultSet.getString(7));

                Blob blob =resultSet.getBlob(6);
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[4096];
                int bytesRead=-1;
                while ((bytesRead = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String userImage = Base64.getEncoder().encodeToString(imageBytes);


                inputStream.close();
                outputStream.close();

                userDto.setUserImage(userImage );
                userDetails.add(userDto);

            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return userDetails;
    }
}
