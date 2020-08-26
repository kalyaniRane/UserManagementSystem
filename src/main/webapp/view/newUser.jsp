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
        </main>
    </div>
</div>
</body>
</html>
