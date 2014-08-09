<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/10/2014
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/foundation.css" />"/>
    <script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
    <title>Create the Pizzabase</title>
</head>
<body>
<h2 align="center">Hello This is page for admin</h2>


<div class="large-12 medium-5 columns" align="center">
    <p>
        <a href="subprop/index" class="medium success button">Manage Excipeint property</a>
        <a href="propertyIndex" class="medium success button">Manage Excipient</a>
        <a href="excipient" class="medium alert button">Manage Drug Formulation</a>
    </p>
</div>
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script>
$(document).foundation();
</script>
</body>
</html>
