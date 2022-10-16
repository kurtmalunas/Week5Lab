<%-- 
    Document   : login
    Created on : 15-Oct-2022, 11:46:17 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username  }"><br>
            Password: <input type="text" name="password"><br>
            <input type="submit" value="Log in">
        </form>
        ${incorrectLogin}
    </body>
</html>
