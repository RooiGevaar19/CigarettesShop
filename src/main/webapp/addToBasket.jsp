
<%@page import="com.example.servletjspdemo.domain.Cigarette"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center><img src="newicon1great50.png">
    <h2>Sklep z papierosami</h2></center>
<%
	out.println("<h3>Dostępne produkty:</h3><br>\n");
	out.println("<table>");
	out.println("<th>Nazwa</th> <th>Cena</th> <th>Dostępność w sztukach</th> <th>Akcja</th>\n");
    for (Cigarette entry : storage.getAllCigarettes()) {
    	out.println("<form action=\"makedelivery\" >\n" +
    				//"<table>"+
                    "<tr><td>"+entry.getName()+"</td><td>"+String.format("%.2f PLN", entry.getPrice())+"</td><td>"+String.valueOf(entry.getCount())+"</td>\n" +
                    "<td><input type=\"hidden\" name=\"name\" value=\""+entry.getName()+"\">\n" 
                   +"<input type=\"hidden\" name=\"price\" value=\""+entry.getPrice()+"\">\n"
                   +"<input type=\"hidden\" name=\"count\" value=\""+entry.getCount()+"\">\n"
                   +"<input type=\"hidden\" name=\"id\" value=\""+entry.getId()+"\">\n"
                   +"<input type=\"submit\" value=\"Dodaj do koszyka\"></td></tr>\n" +
             		//"</table>"+
                    "</form>");
    }
    out.println("</table>");
%>
<a href="index.jsp">Wstecz</a>
</body>
</html>