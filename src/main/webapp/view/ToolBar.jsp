<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 19-08-2020
  Time: 01:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="css/toolbar.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<title>User Management</title>
<body>
        <div class="dashboard-header">
            <div class="header-title">
                <h6>User Management</h6>
            </div>

            <button type="button" onclick="toggleSideToolBar()" class="btn-toggle-fullwidth navbar-btn">
                <i class="ti-arrow-circle-right" id="header-button-icon"></i>
            </button>

            <div class="dashboard-nav-right">
                <a class="dashboard-user-name">${userName}</a>
                <div class="dashboard-nav-right-dropdown-menu">
                    <a href="#"><i class="ti-user" id="icon-header1"></i>Profile</a>
                    <a href="#"><i class="ti-power-off" id="icon-header2"></i>Logout</a>
                </div>
            </div>
        </div>
</body>
</html>
