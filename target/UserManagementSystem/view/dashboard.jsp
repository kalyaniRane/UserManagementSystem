<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 21-08-2020
  Time: 01:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>User Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dashboard.css">
    <link rel="stylesheet" href="css/sideToolBar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="script/dashboard.js"></script>
</head>
<body>

<div class="dashboard">
    <%@include file="ToolBar.jsp"%>
    <div class="dashboard-body">
        <%@include file = "sideToolBar.jsp" %>
        <main class="dashboard-main" id="dashboard-main">
            <div class="dashboard-main-header">
                <h1 class="page-title">Welcome ${userName}</h1>
                <p class="page-subtitle">You last logged in on: Aug 24 2020 7:36PM</p>
                <ul class="user-breadcrumb">
                    <li>
                        <a href="dashboard"><i class="fa fa-home"></i>Home</a>
                    </li>
                    <li class="active">
                        Dashboard
                    </li>
                </ul>
            </div>
        </main>
    </div>
</div>

</body>
</html>
