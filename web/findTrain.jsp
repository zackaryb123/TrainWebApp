<%@ page import="Model.Train" %>
<%@ page import="Model.Ticket" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="TrainDao" class="Dao.Jdbc.JdbcTrainDao"/>

<%
    String tNo = request.getParameter("tNo");

    if(tNo != null){

        Train train = TrainDao.findTrain(Integer.valueOf(tNo));
        session.setAttribute("train", train);

        if(train.getTrainName().equals("default")){
            request.setAttribute("errMsg", "Train Does Not Exist!");
            %><jsp:forward page="trainNo.jsp"/><%
        } else {
            Ticket ticket = new Ticket(LocalDate.now(), train);
            ticket.setTrain(train);
            session.setAttribute("ticket", ticket);
        }
    }
    pageContext.setAttribute("errMsg", request.getAttribute("errMsg"));
%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
</head>
<body class="container background1">
    <h1>Train Details</h1>
    <form action="ticketDetails.jsp" method="get">
        <label for="tDate">Train Date</label><br>
        <input class="form-control" id="tDate" name="tDate" type="text" required/><br><br>
        <%--<label for="tPassNum">Number of Passengers</label><br>--%>
        <%--<input class="form-control" id="tPassNum" name="tPassNum" type="number" required><br><br>--%>
        <button class="btn btn-primary mb-2"  type="submit">Submit</button>
    </form>
<div>
    <c:if test="${errMsg != null}">
        <p class="text-danger">${errMsg}</p>
    </c:if>
</div>
</body>
</html>
