<%@ page import="Model.Ticket" %>
<%@ page import="Model.Passenger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String num = request.getParameter("pNum");
    if(num != null){
        Ticket ticket = (Ticket) session.getAttribute("ticket");
        int pNum = Integer.valueOf(num);
        System.out.println(pNum);
        if(pNum < 1){
            request.setAttribute("errMsg", "Must have at least one passenger!");
            %><jsp:forward page="ticketDetails.jsp"/><%
        } else {
            Passenger[] passengers = new Passenger[pNum];
            for(int i=0; i<pNum; i++){
                String name = request.getParameter("name"+i);
                String age = request.getParameter("age"+i);
                String gender = request.getParameter("gender"+i);
                Passenger p = new Passenger(name, Integer.valueOf(age), gender.charAt(0));
                ticket.addPassenger(p);
                passengers[i] = p;
            }
            pageContext.setAttribute("passengers", passengers);
        }
        ticket.calculateTotalTicketPrice();
        session.setAttribute("ticket", ticket);
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
</head>
<body class="container background">
<div class=" text-center">
    <h1>Ticket</h1>
    <p>PNR: ${ticket.pnr}</p>
    <p>Date: ${ticket.travelDate}</p>
    <p>Train_No: ${ticket.train.trainNo}</p>
    <p>Train Name: ${ticket.train.trainName}</p>
    <p>Source: ${ticket.train.source}</p>
    <p>Destination: ${ticket.train.destination}</p>
    <c:forEach var="i" begin="0" end="${fn:length(passengers)-1}">
        <h3>Passenger: ${passengers[i].name}</h3>
        <p>Age: ${passengers[i].age}</p>
        <p>Gender: ${passengers[i].gender}</p>
        <p>Price: ${ticket.passengers.get(passengers[i])}</p>
    </c:forEach>
    <h3>Total Ticket Price: ${ticket.totalPrice}</h3>
    <form action="printTicket.jsp" method="get">
        <button class="btn btn-primary mb-2" type="submit">Print Ticket</button>
    </form>
</div>
</body>
</html>
