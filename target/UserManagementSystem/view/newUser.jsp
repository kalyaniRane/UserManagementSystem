<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kalyani
  Date: 25-08-2020
  Time: 01:18 PM
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
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("userName")==null) {
        session.setAttribute("message","Please Login");
        response.sendRedirect("login");
    }
%>
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
            <form class="new-user-form" action="newUser" method="post" enctype="multipart/form-data">
                <div class="new-user-information-profile-image">
                    <div class="new-user-information-with-header">
                        <div class="new-user-information-header">
                            General
                        </div>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>First Name</span>
                                <input type="text" required pattern="^[A-Z][a-z]{2,}"
                                       title="Starting letter must be upper case and followed by lowercase letters with minimum of 3 characters"
                                       name="firstName" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Middle Name</span>
                                <input type="text" required pattern="^[A-Z][a-z]{2,}"
                                       title="Starting letter must be upper case and followed by lowercase letters with minimum of 3 characters"
                                       name="middleName" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Last Name</span>
                                <input type="text" required pattern="^[A-Z][a-z]{2,}"
                                       title="Starting letter must be upper case and followed by lowercase letters with minimum of 3 characters"
                                       name="lastName" class="new-user-input">
                            </div>
                        </div>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>Date Of Birth</span>
                                <input type="date" required name="dateOfBirth" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Gender</span>
                                <select name="gender" required class="new-user-input">
                                    <option>--Select--</option>
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="new-user-details">
                                <span>Country</span>
                                <select name="country" required class="new-user-input">
                                    <option>--Select--</option>
                                    <option>Singapore</option>
                                    <option>Malaysia</option>
                                    <option>India</option>
                                    <option>Italy</option>
                                    <option>Iraq</option>
                                    <option>Egypt</option>
                                </select>
                            </div>
                        </div>
                        <div class="new-user-information-form1">
                            <div class="new-user-details">
                                <span>Country Code</span>
                                <input type="text" required name="countryCode" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Mobile Number</span>
                                <input type="text" required name="mobileNumber" pattern="[0-9]{5,10}"
                                       title="Mobile number must contain 5-10 digits" class="new-user-input">
                            </div>
                        </div>
                        <div class="new-user-information-form1">
                            <div class="new-user-details">
                                <span>Email</span>
                                <input required type="text" pattern="^[a-zA-Z0-9]+([._+-][0-9a-zA-Z]+)*@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}([.][a-zA-Z]{2,3})?$"
                                       title="sample email pattern - char@char.com or char@char.com.in"
                                       name="email" class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Address</span>
                                <textarea name="address" class="new-user-input new-user-address" required></textarea>
                            </div>
                        </div>
                        <hr>
                        <div class="new-user-information-form">
                            <div class="new-user-details">
                                <span>User Name</span>
                                <input required type="text" name="userName" pattern="{5,}" title="Name must contain minimum of 5 characters"
                                       class="new-user-input">
                            </div>
                            <div class="new-user-details">
                                <span>Password</span>
                                <input required name="password" pattern="(?=.*[A-Z])(?=.*[^0-9a-zA-Z])(?=.*[0-9]).{8,}"
                                       title="Password must contain atleast one capital letter, special character and number with minimum of 8 characters"
                                       class="new-user-input" type="password">
                            </div>
                            <div class="new-user-details">
                                <span>Confirm Password</span>
                                <input required name="confirmPassword" pattern="(?=.*[A-Z])(?=.*[^0-9a-zA-Z])(?=.*[0-9]).{8,}"
                                       title="Password must contain atleast one capital letter, special character and number with minimum of 8 characters"
                                       class="new-user-input" type="password">
                            </div>
                        </div>
                        <div class="new-user-details">
                            <span>User Role</span>
                            <select name="userRole" class="new-user-input" id="new-user-role" required onchange="setPermissions()">
                                <option value disabled selected>-- Select --</option>
                                <option>User</option>
                                <option>Admin</option>
                            </select>
                        </div>
                        <div id="password-message"></div>
                    </div>
                    <div class="new-user-profile">
                        <div class="new-user-profile-header">Photo</div>
                        <div class="new-user-profile-details">
                            <label class="new-user-profile-label">Acceptable image formats are jpg, jpeg, png &amp; gif.</label>
                            <label class="new-user-profile-label">Maximum image size allowed is 2MB.</label>
                            <div class="dropify-wrapper">
                                <div class="dropify-message">
                                    <span class="file-icon"></span>
                                    <p>Click here to choose any image</p>
                                    <p class="dropify-error">Ooops, something wrong appended.</p>
                                </div>
                                <div class="dropify-loader" style="display: none;"></div>
                                <div class="dropify-errors-container"><ul></ul></div>
                                <input type="file" id="input-file-now" class="dropify" data-show-loader="true"
                                       data-show-remove="true" data-errors-position="inside" name="new-user-profile-image"
                                       data-allowed-file-extensions="png jpeg jpg gif" data-max-file-size="2M">
                                <button type="button" class="dropify-clear">Remove</button>
                                <div class="dropify-preview" style="display: none;">
                                    <span class="dropify-render"></span>
                                    <div class="dropify-infos">
                                        <div class="dropify-infos-inner">
                                            <p class="dropify-filename">
                                                <span class="file-icon"></span>
                                                <span class="dropify-filename-inner">SCCL RECPT.pdf</span>
                                            </p>
                                            <p class="dropify-infos-message">Drag and drop or click to replace</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="new-user-permission">
                    <div class="new-user-permission-header">Permissions</div>
                    <div class="new-user-permission-table-div  table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Web Page</th>
                                <th>
                                    <input type="checkbox" name="webpageAdd" class="permission-table-input permission-add"
                                           value="true" onchange="toggleCheckBoxes(this)">
                                    <input type="hidden" name="webpageAdd" class="permission-table-input" value="false">
                                    <span>Add</span>
                                </th>
                                <th>
                                    <input type="checkbox" name="webpageDelete" class="permission-table-input permission-delete"
                                           value="true" onchange="toggleCheckBoxes(this)">
                                    <input type="hidden" name="webpageDelete" class="permission-table-input" value="false">
                                    <span>Delete</span>
                                </th>
                                <th>
                                    <input type="checkbox" name="webpageModify" class="permission-table-input permission-modify"
                                           value="true" onchange="toggleCheckBoxes(this)">
                                    <span>Modify</span>
                                </th>
                                <th>
                                    <input type="checkbox" name="webpageRead" class="permission-table-input permission-read"
                                           value="true" onchange="toggleCheckBoxes(this)">
                                    <span>Read</span>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Dashboard</td>
                                <td><input type="checkbox" name="dashboard-add" class="permission-table-input permission-add" value="true">
                                    <input type="hidden" name="dashboard-add" class="permission-table-input" value="false">
                                </td>
                                <td><input type="checkbox" name="dashboard-delete permission-delete" class="permission-table-input permission-delete" value="true">
                                    <input type="hidden" name="dashboard-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="dashboard-modify" class="permission-table-input permission-modify" value="true">
                                    <input type="hidden" name="dashboard-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="dashboard-read" class="permission-table-input permission-read" value="true">
                                    <input type="hidden" name="dashboard-read" class="permission-table-input" value="false"></td>
                            </tr>
                            <tr>
                                <td>Settings</td>
                                <td>
                                    <input type="checkbox" name="settings-add" class="permission-table-input permission-add" value="true">
                                    <input type="hidden" name="settings-add" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="settings-delete permission-delete" class="permission-table-input permission-delete" value="true">
                                    <input type="hidden" name="settings-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="settings-modify" class="permission-table-input permission-modify" value="true">
                                    <input type="hidden" name="settings-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="settings-read" class="permission-table-input permission-read" value="true">
                                    <input type="hidden" name="settings-read" class="permission-table-input" value="false"></td>
                            </tr>
                            <tr>
                                <td>Users Information</td>
                                <td><input type="checkbox" name="userinfo-add" class="permission-table-input permission-add" value="true">
                                    <input type="hidden" name="userinfo-add" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="userinfo-delete" class="permission-table-input permission-delete" value="true">
                                    <input type="hidden" name="userinfo-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="userinfo-modify" class="permission-table-input permission-modify permission-user" value="true">
                                    <input type="hidden" name="userinfo-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="userinfo-read" class="permission-table-input permission-read" value="true">
                                    <input type="hidden" name="userinfo-read" class="permission-table-input" value="false"></td>
                            </tr>
                            <tr>
                                <td>Web Page 1</td>
                                <td><input type="checkbox" name="webpage1-add" class="permission-table-input permission-add  permission-user" value="true">
                                    <input type="hidden" name="webpage1-add" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage1-delete" class="permission-table-input permission-delete" value="true">
                                    <input type="hidden" name="webpage1-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage1-modify" class="permission-table-input permission-modify permission-user" value="true">
                                    <input type="hidden" name="webpage1-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage1-read" class="permission-table-input permission-read permission-user" value="true">
                                    <input type="hidden" name="webpage1-read" class="permission-table-input" value="false"></td>
                            </tr>
                            <tr>
                                <td>Web Page 2</td>
                                <td><input type="checkbox" name="webpage2-add" class="permission-table-input permission-add permission-user" value="true">
                                    <input type="hidden" name="webpage2-add" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage2-delete" class="permission-table-input permission-delete" value="true">
                                    <input type="hidden" name="webpage2-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage2-modify" class="permission-table-input permission-modify permission-user" value="true">
                                    <input type="hidden" name="webpage2-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage2-read" class="permission-table-input permission-read  permission-user" value="true">
                                    <input type="hidden" name="webpage2-read" class="permission-table-input" value="false"></td>
                            </tr>
                            <tr>
                                <td>Web Page 3</td>
                                <td><input type="checkbox" name="webpage3-add" class="permission-table-input permission-add permission-user" value="true">
                                    <input type="hidden" name="webpage3-add" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage3-delete" class="permission-table-input permission-delete" value="1">
                                    <input type="hidden" name="webpage3-delete" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage3-modify" class="permission-table-input permission-modify permission-user" value="true">
                                    <input type="hidden" name="webpage3-modify" class="permission-table-input" value="false"></td>
                                <td><input type="checkbox" name="webpage3-read" class="permission-table-input permission-read permission-user" value="true">
                                    <input type="hidden" name="webpage3-read" class="permission-table-input" value="false"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="new-user-details-submit-or-reset">
                    <button class="btn btn-primary" id="new-user-submit-button " onclick="return checkPassword()">Submit</button>
                    <button class="btn btn-default" id="new-user-reset-button">Reset</button>
                </div>
            </form>
            <footer class="new-user-footer">
                <div class="container-fluid">
                    <p class="copyright">
                        ©
                        <script type="text/javascript">document.write(new Date().getFullYear())</script>
                        <a href="#">mimtiyaz - CodeCanyon</a>
                    </p>

                </div>
            </footer>
        </main>
    </div>
</div>
</body>
</html>