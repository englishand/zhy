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
        <h1>Welcome��${name}</h1>
        <form action="/ssh/NewServlet" method="Post">
        �û�����<input type="text" value="�������û���" name="user" size="20px"><br>
        ���룺<input type="password" value="����������" name="pswd" size="20px"><br>
        
        <input type="submit" value="�ύ" size="10px">
        
        <%
        
        %>
    </form>
    </body>
</html>
