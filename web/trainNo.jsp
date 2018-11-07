<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="UserDao" class="Dao.Jdbc.JdbcUserDao"/>
<%
  pageContext.setAttribute("errMsg", request.getAttribute("errMsg"));

  String username = request.getParameter("username");
  String password = request.getParameter("password");

  boolean isUser = true;
  if(username != null && password != null){
    isUser = UserDao.isUser(username, password);
  }
  if(!isUser){
    request.setAttribute("errMsg", "User does not exist or invalid password!");
    %><jsp:forward page="index.jsp"/><%
  }
%>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
    </head>
  <body class="container background1">
    <h1>Train Station</h1>
    <form action="findTrain.jsp" method="get">
      <label for="tNo">Train Number</label><br>
      <input class="form-control" id="tNo" name="tNo" type="number" required/><br><br>
      <button class="btn btn-primary mb-2" type="submit">Search</button>
    </form>
    <div>
      <c:if test="${errMsg != null}">
        <p class="text-danger">${errMsg}</p>
      </c:if>
    </div>
  </body>
</html>
