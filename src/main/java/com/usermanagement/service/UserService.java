package com.usermanagement.service;

import com.usermanagement.dto.UserDto;
import com.usermanagement.model.UserDao;

import java.util.List;

public class UserService {

    public List<UserDto> getAllUserDetails(){
        return new UserDao().getAllUserDetails();
    }

}
