package com.usermanagement.controller;

import com.usermanagement.dto.UserDto;
import com.usermanagement.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserList extends HttpServlet {

    UserService userService;

    @Override
    public void init() {
        userService=new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> userDetails = userService.getAllUserDetails();
        req.setAttribute("usersDetails", userDetails);
        RequestDispatcher rd = req.getRequestDispatcher("userslist");
        rd.forward(req,resp);
    }
}
