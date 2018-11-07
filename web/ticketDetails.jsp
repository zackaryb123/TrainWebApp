<%@ page import="Model.Ticket" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="DateUtil" class="Util.DateUtil"/>
<%
    String date = request.getParameter("tDate");
    if(date != null){
        boolean valid = DateUtil.dateValidate(date);
        pageContext.setAttribute("isValidDate", valid);
        pageContext.setAttribute("isValidDate", valid);
        Ticket ticket = (Ticket)session.getAttribute("ticket");
        if(valid){
            String[] dateArr = date.split("/");
            LocalDate localDate = LocalDate.of(
                    Integer.valueOf(dateArr[2]),
                    Integer.valueOf(dateArr[1]),
                    Integer.valueOf(dateArr[0]));
            ticket.setTravelDate(localDate);
            session.setAttribute("ticket", ticket);
        } else {
            request.setAttribute("errMsg", "Invalid Date!");
            %><jsp:forward page="findTrain.jsp"/><%
        }
    }
%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
</head>
<body class="container background">
    <h1>Enter Passengers</h1>
    <form action="passengerDetails.jsp" method="get">
        <div id="PassContainer" class="form-group container">
            <input id="pNum" type="number" name="pNum" value="0" hidden/>
        </div>
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <button class="btn btn-primary mb-2" id="AddPass" type="button" value="0">Add Passanger</button><br><br>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="Second group">
                <button class="btn btn-primary mb-2" type="submit">Generate Ticket</button>
            </div>
        </div>
    </form>
    <div>
        <c:if test="${errMsg != null}">
            <p class="text-danger">${errMsg}</p>
        </c:if>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="index.js"></script>
</html>
