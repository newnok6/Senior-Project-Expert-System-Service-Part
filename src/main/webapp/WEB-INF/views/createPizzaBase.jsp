<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/10/2014
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Create the Pizzabase</title>
</head>
<body>
<h2 align="center">This is a form for adding a new PizzaBase</h2>
<div align="center">
    <table width="200" border="1">
        <form action="adding_pizzabase" method="post">
            <input type="hidden" name="id">
            <label for="name">PizzaBase Name</label>
            <input type="text" id="name" name="name"/>
            <label for="size">PizzaBase size</label>
            <input type="text" id="size" name="size"/>
            <input type="submit" value="Submit"/>
        </form>
    </table>
    </div>
</body>
</html>
