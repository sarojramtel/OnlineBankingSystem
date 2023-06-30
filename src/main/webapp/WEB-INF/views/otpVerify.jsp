<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/22/2023
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Verify OTP</title>
    <style>
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border: none;
            border-radius: 3px;
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }
        input{
            width: 100%;
            /*padding: 8 px;*/
            margin:10px;
        }
        #container {
            display: flex;
            flex-direction: column;
            align-items: center;

            justify-content: center;
            margin: 30px;
        }
    </style>
</head>
<body style="display: flex; justify-content: center; align-items: center; height: 100vh;">
<div id="container">
        <h1>Online Banking System</h1>

        <form style="width: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f5f5f5;" action="verifyotp" method="post">
            <input type="text" id="otp" name="otp" placeholder="Enter OTP" style="text-align: center">
            <input type="submit" id="submit" value="Submit">
            <c:if test="${not empty wrong}">
                <div class="error-message" style="color: red">
                        ${wrong}
                </div>
            </c:if>
        </form>
<%--    <c:if test="${!check}">--%>
<%--        <p>Wrong Otp</p>--%>
<%--    </c:if>--%>
</div>
</body>
</html>
