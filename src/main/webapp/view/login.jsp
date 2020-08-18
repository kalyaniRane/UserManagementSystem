<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 20-08-2020
  Time: 06:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body class="login-body">

<div class="container">
    <div class="card main">
        <form action="dashboard" method="post">
            <div class="card-body left">
                <div class="content">
                    <div class="header">
                        <div class="text-content">
                            <img src="./resources/mi-logo.jpg" class="img-circle img-thumbnail img-responsive"/>
                        </div>
                        <p class="lead">Login to your account</p>
                    </div>
                    <div class="form-group">
                        <input type="text" name="user" placeholder="Username" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" name="pass" placeholder="Password" class="form-control">
                    </div>
                    <div class="content-checkbox">
                        <label class="switch">
                            <input type="checkbox" class="js-switch" checked>
                            <span class="slider round" style="border-color: #6E6E6E"></span>
                        </label>
                        <label style="margin-left: 2%;margin-top: -0.5%;color: darkgrey">Remember Me</label>
                    </div>
                    <input type="submit" name="btnLogin" value="LOGIN" class="btn btn-primary btn-lg btn-block">
                    <div class="forgot-div">
                    <span class="helper-text">
                        <i class="fa fa-lock"></i>
                        <a class="forgot-link" href="forgotpassword">Forgot Password ?</a>
                    </span>
                    </div>
                </div>
            </div>
        </form>
        <div class="card-body right">
            <div class="overlay">
                <div class="text">
                    <h3 style="color: white;font-family: sans-serif;">
                        User Management
                    </h3>
                    <p style="color: white;font-size: 18px;font-family: sans-serif;">
                        Version 2.2
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
