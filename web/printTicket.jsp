<%@ page import="Model.Ticket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Ticket ticket = (Ticket) session.getAttribute("ticket");
    pageContext.setAttribute("ticket", ticket);
    ticket.writeTicket();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css"/>
</head>
<body class="text-center background1 container">
<h1 class="text-success">Ticket printed at "ticket_files/${ticket.pnr}"</h1>
</body>
</html>
