<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj towar</title>
</head>
<body>
	<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="session" />
	<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
	<form action="addPerson.jsp">
		Nazwa towaru :<input type="text" name="Name" value="${cigarette.Name}" /><br />
		Cena za sztukę :<input type="text" name="Name" value="${cigarette.Price}" /><br />
		Ilość :<input type="text" name="Name" value="${cigarette.Count}" /><br />
		<input type="submit" value=" OK ">
	</form>
</body>
</html>