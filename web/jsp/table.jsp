<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%@ page import="org.springframework.web.context.request.RequestScope" %>
<%@ page import="pojo.Information" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaiPeng
  Date: 2020/12/22
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/SpringMVC/add" method="post">
    姓名：<input type="text" name="name" ><br>
    密码：<input type="text" name="pwd"><br>
    手机号：<input type="text" name="phone">
    <button>添加</button>
</form>
<%--<%Object bb=request.get%>--%>

<%--<%Object bb=request.getAttribute("ulist");%>--%>
<%--<%LinkedList<Information> ba=(LinkedList <Information>) bb;%>--%>
<%--${ba}--%>

<%--<c:if test="${ba!=null}">--%>
<%--${requestScope.ulist}--%>
<%--    <c:set property="request" var="ulist" value="${requestScope.ulist}"></c:set>--%>
    <tr>
        <th>账户</th>
        <th>密码</th>
        <th>手机号</th>
    </tr>

    <c:forEach items="${ulist}" var="pp" varStatus="num">
        <tr>
            <td>${pp.acc}</td>
            <td>${pp.pwd}</td>
            <td>${pp.phone}</td>
        </tr>

    </c:forEach>
<%--</c:if>--%>





</body>
</html>
