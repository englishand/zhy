<%-- 
    Document   : cost_list
    Created on : 2018-9-30, 10:53:23
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="pages" style="width: 80%;height: auto;">
            <tr>
                <td>消费id</td><td>消费名称</td>
                <td>消费时常</td><td>基本费用</td>
                <td>单位费用</td><td>创建时间</td>
                <td>开通时间</td><td>状态</td>
                <td></td>               
            </tr>


            <c:forEach items="${costList}" var="cost"><!--使用JSTL中forEach标签循环显示-->
                <tr><td>${cost.id}</td>	<!--使用EL-->	<td><a href="#">${cost.name}</a></td>
                    <td>${cost.baseDuration }小时</td>	<td>${cost.baseCost }元</td>
                    <td>${cost.unitCost }元/小时</td>		<td>${cost.creaTime }</td>
                    <td>${cost.startTime }</td>
                    <td>	<c:if test="${cost.status == 0}">开通</c:if>
                        <c:if test="${cost.status == 1}">暂停</c:if>
                        <c:if test="${cost.status == 2}">删除</c:if></td>
                    <td><c:if test="${cost.status == 0}">
                            <input type="button" value="暂停" class="btn_pause" /></c:if>
                        <c:if test="${cost.status == 1}">
                            <input type="button" value="启用" class="btn_start" /></c:if>
                            <input type="button" value="修改" class="btn_modify" />
                            <input type="button" value="删除" class="btn_delete" /></td>
                    </tr></c:forEach>

                


        </table>
        <div style="margin-left: 30%;margin-top: 1%;">
            <a href="cost.action?page=1" style="margin-right: 1%">首页</a>
                <c:choose><c:when test="${page > 1}">
                        <a href="cost.action?page=${page-1}" style="margin-right: 1%">上一页</a>
                    </c:when>
                        <c:otherwise><a href="#" style="margin-right: 1%">上一页</a></c:otherwise>
                </c:choose>
                <c:forEach begin="1" end="${totalPages}" var="p" ><!--forEach用法见JSP笔记3.3-->
                    <c:choose><c:when test="${page == p}">
                            <a href="cost.action?page=${p}" class="current_page">${p }</a>
                        </c:when>
                        <c:otherwise><a href="cost.action?page=${p}">${p }</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose> <c:when test="${page < totalPages}">
                        <a href="cost.action?page=${page+1}" style="margin-left: 1%">下一页</a>
                    </c:when>
                    <c:otherwise><a href="#" style="margin-left: 1%">下一页</a></c:otherwise>
                </c:choose>
                    <a href="cost.action?page=${totalPages }" style="margin-left: 1%">末页</a>
            </div>
    </body>
</html>
