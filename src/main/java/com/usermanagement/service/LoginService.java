package com.usermanagement.service;


import com.usermanagement.dto.LoginDto;
import com.usermanagement.model.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService {

    public void userLogin(String userName, String password, HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException {
        LoginDto loginDto=new LoginDto();
        loginDto.setUserName(userName);
        loginDto.setPassword(password);
        HttpSession session=req.getSession();
        UserDao userDao =new UserDao();

        try{
            if(userDao.validate(loginDto)){
                req.setAttribute("userName",userName);
                session.setAttribute("userName",loginDto.getUserName());
                req.getRequestDispatcher("view/dashboard.jsp").forward(req,resp);
            }
            else{
                session.setAttribute("message","Enter Valid UserName and Password");
                RequestDispatcher reqD= req.getServletContext().getRequestDispatcher("/view/login.jsp");
                reqD.include(req,resp);
            }
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }

    }

}
