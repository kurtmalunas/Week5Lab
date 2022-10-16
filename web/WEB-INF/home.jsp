<%-- 
    Document   : home
    Created on : 15-Oct-2022, 11:58:58 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${username}
        <form method="get" action="login">
            <input type="submit" value="Log out">
            <input type="hidden" name="action" value="Log out">
        </form>
    </body>
</html>
