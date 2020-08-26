<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 25-08-2020
  Time: 01:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="script/dashboard.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.min.css">
    <link rel="stylesheet" href="css/newUser.css">
    <link rel="stylesheet" href="css/toolbar.css">
    <link rel="stylesheet" href="css/sideToolBar.css">

</head>
<body>

<div class="new-user">
    <%@include file = "ToolBar.jsp" %>
    <div class="new-user-body">
        <%@include file = "sideToolBar.jsp" %>
        <main class="new-user-main" id="main">
            <header class="new-user-header">
                <div class="new-user-header-left">
                    New User
                </div>
                <div class="new-user-header-right">
                    <a href="./view/dashboard.jsp"><i class="fa fa-home"></i>Home</a>
                    <span> / New User </span>
                </div>
            </header>
            <form class="new-user-form">
                <div class="new-user-information-profile-image">
                    <div class="new-user-information-with-header">
                        <div class="new-user-information-header">
                            General
                        </div>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>First Name</span>
                                <input  placeholder="First Name" type="text" required
                                        name="firstName" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Middle Name</span>
                                <input  placeholder="Middle Name" type="text"
                                        name="middleName" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Last Name</span>
                                <input  placeholder="Last Name" type="text" required
                                        name="lastName" class="new-user-input">
                            </div>
                        </div>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>Date Of Birth</span>
                                <input placeholder="Date Of Birth" type="date" required name="dateOfBirth" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Gender</span>
                                <select name="gender" class="new-user-input">
                                    <option>Female</option>
                                    <option>Male</option>
                                    <option>Others</option>
                                </select>
                            </div>
                            <div class="new-user-details">
                                <span>Country</span>
                                <select name="country" class="new-user-input">
                                    <option>India</option>
                                    <option>Singapore</option>
                                    <option>Malaysia</option>
                                    <option>Italy</option>
                                    <option>Iraq</option>
                                    <option>Egypt</option>
                                </select>
                            </div>
                        </div>
                        <div class="new-user-information-form1">
                            <div class="new-user-details">
                                <span>Country Code</span>
                                <input type="text" placeholder="Country code" required name="countryCode" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Mobile Number</span>
                                <input type="number" placeholder="Mobile Number" required name="mobileNumber" class="new-user-input">
                            </div>
                        </div>
                        <div class="new-user-information-form1">
                            <div class="new-user-details">
                                <span>Email</span>
                                <input required placeholder="Email ID" type="text"
                                       name="email" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Address</span>
                                <textarea placeholder="Address" name="address" class="new-user-input new-user-address"></textarea>
                            </div>
                        </div>
                        <hr>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>User Name</span>
                                <input required placeholder="User Name" type="text" name="userName" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Password</span>
                                <input required name="password"
                                       class="new-user-input" type="password" placeholder="Password" >
                            </div>
                            <div class="new-user-details">
                                <span>Confirm Password</span>
                                <input required name="confirmPassword"
                                       class="new-user-input" type="password" placeholder="Password" >
                            </div>
                        </div>
                        <div class="new-user-details">
                            <span>User Role</span>
                            <select name="userRole" class="new-user-input">
                                <option>User</option>
                                <option>Admin</option>
                            </select>
                        </div>
                    </div>
                </div>
            </form>
        </main>
    </div>
</div>
</body>
</html>
