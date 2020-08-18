package com.usermanagement.controller;

import com.usermanagement.service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/dashboard"})
public class Login extends HttpServlet {

    LoginService loginService;

    @Override
    public void init(){
        loginService=new LoginService();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("user");
        String password = req.getParameter("pass");

        loginService.userLogin(userName,password,req,resp);
    }
}
