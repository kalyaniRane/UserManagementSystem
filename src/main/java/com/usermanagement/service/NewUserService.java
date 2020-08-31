package com.usermanagement.service;

import com.usermanagement.dto.NewUserDto;
import com.usermanagement.dto.UserDto;
import com.usermanagement.model.UserDao;

public class NewUserService {


    public String addUser(NewUserDto newUser) {

        UserDao userDAO = new UserDao();
        UserDto user = userDAO.getUserDetailByEmail(newUser.getEmailId());
        if(user != null)
            return "EMAIL_EXISTS";
        UserDto user1 = userDAO.getUserDetailsByUserName(newUser.getUserName());
        if(user1 != null)
            return "USER_NAME_EXISTS";
        if(userDAO.addUser(newUser))
            return "USER_ADDED";
        return "SERVER_SIDE_PROBLEM_TRY_AGAIN_LATER";
    }


}
