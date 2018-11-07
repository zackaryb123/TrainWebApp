<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("errMsg", request.getAttribute("errMsg"));
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
</head>
<body class="container background1">
<div>
    <h1>Login</h1>
    <form action="trainNo.jsp" method="get">
        <div class="form-group">
            <label for="username">Username</label><br>
            <input class="form-control" id="username" name="username" type="text" required/><br><br>
            <label for="password">Password</label><br>
            <input class="form-control" id="password" name="password" type="password" required/><br><br>
            <button class="btn btn-primary mb-2" type="submit">Login</button>
        </div>
    </form>
</div>
<div>
    <c:if test="${errMsg != null}">
        <p class="text-danger">${errMsg}</p>
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
