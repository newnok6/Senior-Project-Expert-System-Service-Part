<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/10/2014
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show all PizzaBase</title>

</head>
<body>

<table border="1">
    <c:forEach var="pizzaBase" items="${pizzaBaseList}">
        <tr>
            <td>${pizzaBase.name}</td><td><input type="button" value="delete" onclick="window.location='person/delete?id=${person.id}'"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
