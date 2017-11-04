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
    

	<center><p><h3>Pomyślnie usunięto z bazy</h3></p><center>
	<p>
  		<center>
  		<btc><a href="cigList">Pokaż wszystkie towary</a></btc>
  		<btc><a href="index.jsp">Wstecz</a></btc>
  		</center>
	</p>
</body>
</html>