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
<body style="display: flex; justify-content: center; align-items: center; height: 100vh;">
<%--    <%--%>
<%--        String name = (String)request.getAttribute("name");--%>
<%--    %>--%>
<%--    <p>Name is <%=name%></p>--%>
<div id="container">
    <form style="width: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f5f5f5;" action="processform" method="post">

<%--        <input type="text" id="id" name="id" placeholder="ID" /> <br/>--%>

        <input type="text" id="name" name="name" placeholder="Name" /> <br/>

        <input type="text" id="email" name="email" placeholder="E-mail" /> <br/>

        <input type="text" id="contact" name="contact" placeholder="Contact" /><br />

        <input type="text" id="username" name="username" placeholder="Username" /><br />

        <input type="password" id="password" name="password" placeholder="Password" /><br />

        <input type="submit" value="Sign Up" />
    </form>
</div>



</div>
</body>
</html>