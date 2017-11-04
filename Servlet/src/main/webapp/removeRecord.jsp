<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytuj towar</title>
<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center><img src="newicon1great50.png">
    <h2>Sklep z papierosami</h2></center><hr>
	<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="session" />
	<jsp:setProperty name="cigarette" property="*" />
	<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
	<% 
  	cigarette = storage.getCigaretteByID(Integer.parseInt(request.getParameter("id")));
	
	%>
	<h3>Zamierzasz usunąć ponizszy przedmiot:</h3>
	<form action="removeCigarette" style="margin-left:0.1in; display:inline" method="post">
		<input type="hidden" name="id" value="${cigarette.id}" />
		<p><b>Nazwa:</b> <jsp:getProperty name="cigarette" property="name"></jsp:getProperty></p>
		<p><b>Cena:</b> <jsp:getProperty name="cigarette" property="price"></jsp:getProperty></p>
		<p><b>Ilość sztuk:</b> <jsp:getProperty name="cigarette" property="count"></jsp:getProperty></p>
		<input class="button" type="submit" value=" Potwierdź " style="display:inline">
	</form>
	<btl><a href="cigList">Wróć</a></btl>
</body>
</html>