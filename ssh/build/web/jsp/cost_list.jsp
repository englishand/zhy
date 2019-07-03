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
                <td>����id</td><td>��������</td>
                <td>����ʱ��</td><td>��������</td>
                <td>��λ����</td><td>����ʱ��</td>
                <td>��ͨʱ��</td><td>״̬</td>
                <td></td>               
            </tr>


            <c:forEach items="${costList}" var="cost"><!--ʹ��JSTL��forEach��ǩѭ����ʾ-->
                <tr><td>${cost.id}</td>	<!--ʹ��EL-->	<td><a href="#">${cost.name}</a></td>
                    <td>${cost.baseDuration }Сʱ</td>	<td>${cost.baseCost }Ԫ</td>
                    <td>${cost.unitCost }Ԫ/Сʱ</td>		<td>${cost.creaTime }</td>
                    <td>${cost.startTime }</td>
                    <td>	<c:if test="${cost.status == 0}">��ͨ</c:if>
                        <c:if test="${cost.status == 1}">��ͣ</c:if>
                        <c:if test="${cost.status == 2}">ɾ��</c:if></td>
                    <td><c:if test="${cost.status == 0}">
                            <input type="button" value="��ͣ" class="btn_pause" /></c:if>
                        <c:if test="${cost.status == 1}">
                            <input type="button" value="����" class="btn_start" /></c:if>
                            <input type="button" value="�޸�" class="btn_modify" />
                            <input type="button" value="ɾ��" class="btn_delete" /></td>
                    </tr></c:forEach>

                


        </table>
        <div style="margin-left: 30%;margin-top: 1%;">
            <a href="cost.action?page=1" style="margin-right: 1%">��ҳ</a>
                <c:choose><c:when test="${page > 1}">
                        <a href="cost.action?page=${page-1}" style="margin-right: 1%">��һҳ</a>
                    </c:when>
                        <c:otherwise><a href="#" style="margin-right: 1%">��һҳ</a></c:otherwise>
                </c:choose>
                <c:forEach begin="1" end="${totalPages}" var="p" ><!--forEach�÷���JSP�ʼ�3.3-->
                    <c:choose><c:when test="${page == p}">
                            <a href="cost.action?page=${p}" class="current_page">${p }</a>
                        </c:when>
                        <c:otherwise><a href="cost.action?page=${p}">${p }</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose> <c:when test="${page < totalPages}">
                        <a href="cost.action?page=${page+1}" style="margin-left: 1%">��һҳ</a>
                    </c:when>
                    <c:otherwise><a href="#" style="margin-left: 1%">��һҳ</a></c:otherwise>
                </c:choose>
                    <a href="cost.action?page=${totalPages }" style="margin-left: 1%">ĩҳ</a>
            </div>
    </body>
</html>
