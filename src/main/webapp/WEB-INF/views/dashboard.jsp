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

        #formnlog{
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
        }
        #sendmoney{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        #balance{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input{
            padding: 10px;
            margin: 10px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border: none;
            border-radius: 3px;
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }
        #navbar{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            background-color: #cccccc;
        }
        .navitem{
            margin: 20px;
            color: #0c6100;
        }
    </style>
</head>
<body>
<div id="navbar">
    <div id="balance">
<p class="navitem">Balance<br>
    <c:if test="${not empty balance}">
    <div class="error-message" style="color: #4caf50">
            ${balance}
    </div>
    </c:if>
    </p>
    </div>
<h1 style="text-align: center;color: #4caf50" class="navitem">Welcome ${userName}!!</h1>
<p class="navitem">Account Number<br>${accountNum}<br>${accountType}</p>

</div>
<div style="text-align: center" id="formnlog">
    <form id="sendmoney" action="sendmoney" method="post">
        <h2 style="color: #4caf50;">Send Money</h2>
        <input type="text" id="accountnumber" name="accountnumber" style="width: 400px; padding: 5px;" placeholder="Account Number">
        <input type="text" id="amount" name="amount" style="width: 400px; padding: 5px;" placeholder="Enter amount">
        <input type="submit" value="Send">
        <c:if test="${not empty confirm}">
            <div class="error-message" style="color: gold">
                    ${confirm}
            </div>
        </c:if>
    </form>
    <div id="transactionlog">
        <h2 style="color: #4caf50;">Transaction Log</h2>

    </div>
</div>

</body>
</html>
