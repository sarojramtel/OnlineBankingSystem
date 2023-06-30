<%@page isELIgnored="false" %>
<html>
<head>
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
        #container{
            display: flex;
            flex-direction: row;
            margin:30px;
        }
    </style>
</head>
<body style="display: flex;flex-direction: column; justify-content: center; align-items: center; height: 100vh;">
<%--    <%--%>
<%--        String name = (String)request.getAttribute("name");--%>
<%--    %>--%>
<%--    <p>Name is <%=name%></p>--%>
<h1 style="font-family: 'Times New Roman';font-size:larger;text-align: center"><B>Online Banking System</B></h1>
<div id="container">
    <form style="width: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f5f5f5;" action="loginform" method="post">


        <%--        <input type="text" id="id" name="id" placeholder="ID" /> <br/>--%>

            <c:if test="${not empty error}">
                <div class="error-message" style="color: red">
                        ${error}
                </div>
            </c:if>

        <input type="text" id="username" name="username" placeholder="Username" required="username cannot be empty"/><br />

        <input type="password" id="password" name="password" placeholder="Password" required="password cannot be empty"/><br />

        <input type="submit" value="Log In" />
    </form>
</div>



</div>
</body>
</html>