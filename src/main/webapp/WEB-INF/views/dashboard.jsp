<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/26/2023
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        #form{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input{
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;color: #4caf50">Welcome ${userName}!!</h1>
<div style="text-align: center" id="form">
    <form>
        <h2 style="color: #4caf50;">Send Money</h2>
        <input type="text" id="accountnumber" style="width: 400px; padding: 5px;" placeholder="Account Number">
        <input type="text" id="amount" style="width: 400px; padding: 5px;" placeholder="Enter amount">
        <input type="submit" style="width:200px;background-color: #4caf50; color: white;border-color: #4caf50" value="Send">
    </form>
</div>

</body>
</html>
