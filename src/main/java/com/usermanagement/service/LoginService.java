package com.usermanagement.service;


import com.usermanagement.dto.LoginDto;
import com.usermanagement.model.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService {

    public void userLogin(String userName, String password, HttpServletRequest req, HttpServletResponse resp) {
        LoginDto loginDto=new LoginDto(userName, password);
        HttpSession session=req.getSession();
        LoginDao loginDao=new LoginDao();

        try{
            if(loginDao.validate(loginDto)){
                req.setAttribute("userName",userName);
                session.setAttribute("user",userName);
                req.getRequestDispatcher("view/dashboard.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("message","Enter Valid UserName and Password");
                RequestDispatcher reqD= req.getServletContext().getRequestDispatcher("/login");
                reqD.include(req,resp);
            }
        }catch (ClassNotFoundException | ServletException | IOException e){
            e.printStackTrace();
        }

    }

}
