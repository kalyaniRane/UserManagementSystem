<%@ page import="com.usermanagement.dto.UserDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mehul
  Date: 9/2/2020
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>User Management</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="script/dashboard.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.min.css">
    <link rel="stylesheet" href="css/sideToolBar.css">
    <link rel="stylesheet" href="css/userList.css">
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("userName")==null) {
        session.setAttribute("message","Please Login");
        response.sendRedirect("login");
    }
%>
<div class="users-list">
    <%@include file = "ToolBar.jsp" %>
    <div class="users-list-body">
        <%@include file = "sideToolBar.jsp" %>
        <main class="users-list-main">
            <header class="users-list-header">
                <div class="users-list-header-left">
                    New User
                </div>
                <div class="users-list-header-right">
                    <a href="./view/dashboard.jsp"><i class="fa fa-home"></i>Home</a>
                    <span> / New User </span>
                </div>
            </header>

            <div class="users-list-content">
                <div class="users-list-content-header">
                    <a href="newuser" class="users-list-content-anchor">
                        <i class="ti-user users-icon"></i>
                        New User
                    </a>
                </div>
                <div class="users-list-filter-search">
                    <select class="users-list-content-select">
                        <option>10</option>
                        <option>20</option>
                        <option>50</option>
                        <option>100</option>
                    </select>
                    <input placeholder="Search.." class="users-list-content-search-input" type="text">
                </div>

                <div class="users-list-main-table">
                    <div class="users-list-table">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>    </th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Dob</th>
                                    <th>Status</th>
                                    <th>Role</th>
                                    <th>Account</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                            <%
                                List<UserDto> userDetails = (List<UserDto>) request.getAttribute("usersDetails");
                                int index=1;
                                for(UserDto user : userDetails){
                            %>

                                <tr>
                                    <td class="users-list-table-image"><img src="data:image/jpg;base64, <%= user.getUserImage()%>"></td>
                                    <td><%= user.getName() %> </td>
                                    <td><%= user.getEmail()%> </td>
                                    <td><%= user.getDateOfBirth()%></td>
                                    <td class="users-status"><label class="users-status-active">Active</label> </td>
                                    <td><%= user.getUserRole()%></td>
                                    <td class="users-account"><i class="ti-unlock text-success"></i></td>
                                    <td class="users-action">
                                        <i class="ti-pencil-alt"></i>
                                        <i class="fa fa-trash text-danger"></i>
                                    </td>
                                </tr>
                            <%
                                index++;}
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>

        </main>
    </div>
</div>

</body>
</html>
