package com.usermanagement.controller;

import com.usermanagement.dto.NewUserDto;
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

        session.setAttribute("message",message);
        session.setAttribute("newUser",newUser);
        resp.sendRedirect("newuser");

    }

}
