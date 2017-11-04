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
	<form action="editCigarette.jsp" style="margin-left:0.1in" method="post">
		<input type="hidden" name="id" value="${cigarette.id}" />
		Nazwa towaru :<input type="text" name="name" value="${cigarette.name}" /><br />
		Cena za sztukę :<input type="text" name="price" value="${cigarette.price}" /><br />
		Ilość :<input type="text" name="count" value="${cigarette.count}" /><br />
		<input type="submit" value=" OK ">
	</form>
	<br>
	<btl><a href="cigList">Wróć</a></btl>
</body>
</html>