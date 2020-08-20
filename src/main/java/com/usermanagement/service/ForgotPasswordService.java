package com.usermanagement.service;

import com.usermanagement.dto.UserDto;
import com.usermanagement.model.LoginDao;

import java.io.PrintWriter;


public class ForgotPasswordService {

    LoginDao loginDao=new LoginDao();

    public String resetPasswordLink(String email) throws ClassNotFoundException {

        UserDto userDetails = loginDao.getUserDetailByEmail(email);

        if(userDetails!=null){
            return "Data Found";
        }

        return "Data Not Found";

    }

}
