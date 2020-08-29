package com.usermanagement.service;

import com.usermanagement.dto.UserDto;
import com.usermanagement.model.UserDao;


public class ForgotPasswordService {

    UserDao userDao =new UserDao();

    public String resetPasswordLink(String email) throws ClassNotFoundException {

        UserDto userDetails = userDao.getUserDetailByEmail(email);
        MailService mailService=new MailService();
        String message = mailService.sendEmail(userDetails);

        return message;

    }

}
