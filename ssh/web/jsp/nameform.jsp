<%-- 
    Document   : nameform
    Created on : 2018-9-29, 17:29:39
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
        <form action="welcome.action" method="post">
            <input name="name" type="text" /><input value="提交" type="submit" />
            <span style="color:red;">${error }</span>
        </form>
    </body>
</html>
