<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a cigarette...</title>
<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="session" />
	<jsp:setProperty name="cigarette" property="*" /> 
	<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
	<center><img src="newicon1great50.png">
    <h2>Sklep z papierosami</h2></center><hr>
    
	<%
	try {
		int a = Integer.parseInt(request.getParameter("id"));
		String b = request.getParameter("name");
		double c = Double.parseDouble(request.getParameter("price"));
		int d = Integer.parseInt(request.getParameter("count"));
		try {
  			storage.editCigarette(a, b, c, d);
  			out.println("<p><h3>Przeedytowano towar w bazie.</h3></p>");
		} catch (SQLException e) {
			out.println("<p><h3>Błąd przy edycji pliku.</h3></p>");
		}
	} catch (NumberFormatException e) {
		out.println("<p><h3>Błąd przy edycji pliku.</h3></p>");
	}
	%>

	<!--<p><h3>Przeedytowano towar w bazie:</h3> </p>
	<p><b>Nazwa:</b> ${cigarette.name} </p>
	<p><b>Cena za sztukę:</b> ${cigarette.price} </p>
	<p><b>Ilość sztuk:</b> <jsp:getProperty name="cigarette" property="count"></jsp:getProperty></p>-->
	<p>
  		<a href="cigList">Pokaż wszystkie towary</a>
  		<a href="index.jsp">Menu główne</a>
	</p>
</body>
</html>