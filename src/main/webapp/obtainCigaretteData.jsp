<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj towar</title>
<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center><img src="newicon1great50.png">
    <h2>Sklep z papierosami</h2></center>
	<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="session" />
	<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
	<form action="addCigarette.jsp">
		Nazwa towaru :<input type="text" name="name" value="${cigarette.name}" /><br />
		Cena za sztukę :<input type="text" name="price" value="${cigarette.price}" /><br />
		Ilość :<input type="text" name="count" value="${cigarette.count}" /><br />
		<input type="submit" value=" OK ">
	</form>
	<a href="index.jsp">Wróć</a>
</body>
</html>