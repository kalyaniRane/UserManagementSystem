package com.usermanagement.controller;

import com.usermanagement.dto.NewUserDto;
import com.usermanagement.dto.PermissionDto;
import com.usermanagement.service.NewUserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/newUser")
@MultipartConfig(maxFileSize = 16177215)
public class NewUser extends HttpServlet {

    NewUserService newUserService;

    @Override
    public void init() {
        newUserService=new NewUserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        NewUserDto newUser=new NewUserDto();
        newUser.setFirstName(req.getParameter("firstName"));
        newUser.setMiddleName(req.getParameter("middleName"));
        newUser.setLastName(req.getParameter("lastName"));
        newUser.setDateOfBirth(req.getParameter("dateOfBirth"));
        newUser.setGender(req.getParameter("gender"));
        newUser.setCountry(req.getParameter("country"));
        newUser.setCountryCode(req.getParameter("countryCode"));
        newUser.setMobileNumber(Long.valueOf(req.getParameter("mobileNumber")));
        newUser.setEmailId(req.getParameter("email"));
        newUser.setAddress(req.getParameter("address"));
        newUser.setUserName(req.getParameter("userName"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setUserRole(req.getParameter("userRole"));

        InputStream inputStream = null;
        Part filePart = req.getPart("new-user-profile-image");
        System.out.println("Image  "+filePart);
        if (filePart == null) {
            inputStream = new FileInputStream("D:\\Servelet\\UserManagementSystem\\src\\main\\webapp\\resources\\default-user-image.png");

        } else {
            inputStream = filePart.getInputStream();
        }
        newUser.setUserImage(inputStream);

        String message = newUserService.addUser(newUser);

        if(message.equals("USER_ADDED")){
            PermissionDto permissionDto=new PermissionDto();
            permissionDto.setDashboardAdd(Boolean.parseBoolean(req.getParameter("dashboard-add")));
            permissionDto.setDashboardDelete(Boolean.parseBoolean(req.getParameter("dashboard-delete")));
            permissionDto.setDashboardModify(Boolean.parseBoolean(req.getParameter("dashboard-modify")));
            permissionDto.setDashboardRead(Boolean.parseBoolean(req.getParameter("dashboard-read")));

            permissionDto.setSettingsAdd(Boolean.parseBoolean(req.getParameter("settings-add")));
            permissionDto.setSettingsDelete(Boolean.parseBoolean(req.getParameter("settings-delete")));
            permissionDto.setSettingsModify(Boolean.parseBoolean(req.getParameter("settings-modify")));
            permissionDto.setSettingsRead(Boolean.parseBoolean(req.getParameter("settings-read")));

            permissionDto.setUserInformationAdd(Boolean.parseBoolean(req.getParameter("userinfo-add")));
            permissionDto.setUserInformationDelete(Boolean.parseBoolean(req.getParameter("userinfo-delete")));
            permissionDto.setUserInformationModify(Boolean.parseBoolean(req.getParameter("userinfo-modify")));
            permissionDto.setUserInformationRead(Boolean.parseBoolean(req.getParameter("userinfo-read")));

            permissionDto.setWebpage1Add(Boolean.parseBoolean(req.getParameter("webpage1-add")));
            permissionDto.setWebpage1Delete(Boolean.parseBoolean(req.getParameter("webpage1-delete")));
            permissionDto.setWebpage1Modify(Boolean.parseBoolean(req.getParameter("webpage1-modify")));
            permissionDto.setWebpage1Read(Boolean.parseBoolean(req.getParameter("webpage1-read")));

            permissionDto.setWebpage2Add(Boolean.parseBoolean(req.getParameter("webpage2-add")));
            permissionDto.setWebpage2Delete(Boolean.parseBoolean(req.getParameter("webpage2-delete")));
            permissionDto.setWebpage2Modify(Boolean.parseBoolean(req.getParameter("webpage2-modify")));
            permissionDto.setWebpage2Read(Boolean.parseBoolean(req.getParameter("webpage2-read")));

            permissionDto.setWebpage3Add(Boolean.parseBoolean(req.getParameter("webpage3-add")));
            permissionDto.setWebpage3Delete(Boolean.parseBoolean(req.getParameter("webpage3-delete")));
            permissionDto.setWebpage3Modify(Boolean.parseBoolean(req.getParameter("webpage3-modify")));
            permissionDto.setWebpage3Read(Boolean.parseBoolean(req.getParameter("webpage3-read")));

            newUserService.addPermission(permissionDto,newUser.getUserName());
        }


        session.setAttribute("message",message);
        session.setAttribute("newUser",newUser);
        resp.sendRedirect("newuser");

    }

}
