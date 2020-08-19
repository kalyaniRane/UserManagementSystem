<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 23-08-2020
  Time: 03:32 PM
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
        <link rel="stylesheet" href="css/forgot.css">
    </head>
    <body>
        <div class="container-forgot">
                <div class="card forgot-main">
                    <div class="card-body forgot-body">
                        <div class="header">
                            <div class="text-center">
                                <img src="./resources/mi-logo.jpg" class="img-circle img-thumbnail img-responsive"/>
                                <h4>
                                    <span class="control-label">User Management</span>
                                </h4>
                            </div>
                            <br>
                            <p class="lead">
                                Recover Password
                            </p>
                            <p class="text-center alert alert-info margin-bottom-30">
                                Please enter your email address below to receive the password at your registered email.
                            </p>
                            <div>
                                <form action="forgot" method="post">
                                <div class="form-group">
                                    <input type="text" name="email" placeholder="Email" class="form-control"
                                           data-bv-notempty="true" data-bv-notempty-message="The email is required."
                                           data-bv-emailaddress="true" data-bv-emailaddress-message="Invalid email address.">
                                </div>

                                <input type="submit" name="recoverBtn" value="RECOVER PASSWORD" class="btn btn-primary btn-lg btn-block">
                                </form>
                                <div class="bottom">
                                    <span class="helper-text">
                                        Know your password? <a href="login">Login</a>
                                    </span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </body>
</html>
