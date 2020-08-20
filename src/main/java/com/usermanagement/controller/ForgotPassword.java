package com.usermanagement.controller;

import com.usermanagement.service.ForgotPasswordService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/forgot"})
public class ForgotPassword extends HttpServlet {

    ForgotPasswordService  forgotPasswordService;

    @Override
    public void init() {
        forgotPasswordService=new ForgotPasswordService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email=req.getParameter("email");

        String result = null;
        try {
             result = forgotPasswordService.resetPasswordLink(email);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        resp.sendRedirect("login");
    }

}
