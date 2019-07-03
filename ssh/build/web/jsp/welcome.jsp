<%-- 
    Document   : welcome
    Created on : 2018-9-29, 17:29:51
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Welcome，${name}</h1>
        <form action="/ssh/NewServlet" method="Post">
        用户名：<input type="text" value="请输入用户名" name="user" size="20px"><br>
        密码：<input type="password" value="请输入密码" name="pswd" size="20px"><br>
        
        <input type="submit" value="提交" size="10px">
        
        <%
        
        %>
    </form>
    </body>
</html>
