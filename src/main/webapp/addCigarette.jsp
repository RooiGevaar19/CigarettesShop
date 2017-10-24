<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a cigarette...</title>
</head>
<body>
	<jsp:useBean id="cigarette" class="com.example.servletjspdemo.domain.Cigarette" scope="session" />
	<jsp:setProperty name="cigarette" property="*" /> 
	<jsp:useBean id="storage" class="com.example.servletjspdemo.service.CigaretteHandler" scope="application" />
	
	<% 
  	storage.addCigarette(cigarette);
	%>

	<p>Dodano towar od bazy: </p>
	<p>Nazwa: ${cigarette.name} </p>
	<p>Cena za sztukę: ${cigarette.price} </p>
	<p>Ilość sztuk: <jsp:getProperty name="cigarette" property="count"></jsp:getProperty></p>
	<p>
  		<a href="cigList">Show all persons</a>
	</p>
</body>
</html>