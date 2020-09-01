package com.usermanagement.service;

import com.usermanagement.dto.NewUserDto;
import com.usermanagement.dto.PermissionDto;
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

    public void addPermission(PermissionDto permissionDto, String userName){

        UserDao userDAO = new UserDao();
        Long userId = userDAO.getUserDetailsByUserName(userName).getId();

        userDAO.addPermission(userId,1,permissionDto.isDashboardAdd(),permissionDto.isDashboardDelete(),permissionDto.isDashboardModify(),permissionDto.isDashboardRead());
        userDAO.addPermission(userId,2,permissionDto.isSettingsAdd(),permissionDto.isSettingsDelete(),permissionDto.isSettingsModify(),permissionDto.isSettingsRead());
        userDAO.addPermission(userId,3,permissionDto.isUserInformationAdd(),permissionDto.isUserInformationDelete(), permissionDto.isUserInformationModify(),permissionDto.isUserInformationRead());
        userDAO.addPermission(userId,4,permissionDto.isWebpage1Add(),permissionDto.isWebpage1Delete(),permissionDto.isWebpage1Modify(),permissionDto.isWebpage1Read());
        userDAO.addPermission(userId,5,permissionDto.isWebpage2Add(),permissionDto.isWebpage2Delete(),permissionDto.isWebpage2Modify(),permissionDto.isWebpage2Read());
        userDAO.addPermission(userId,6,permissionDto.isWebpage3Add(), permissionDto.isWebpage3Delete(),permissionDto.isWebpage3Modify(),permissionDto.isWebpage3Read());
    }

}
