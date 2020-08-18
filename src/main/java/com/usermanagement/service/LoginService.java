package com.usermanagement.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService {

    public void userLogin(String userName, String password, HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session=req.getSession();

        if(userName.equals("admin") && password.equals("123")){
            session.setAttribute("userName",userName);
            try {
                req.getRequestDispatcher("view/dashboard.jsp").forward(req,resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            session.setAttribute("message","Enter Valid Username and Password");
            RequestDispatcher reqD= req.getServletContext().getRequestDispatcher("/view/login.jsp");
            try {
                reqD.include(req,resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }

    }

}
