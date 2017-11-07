<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sklep z papierosami Cigar</title>
        <link href="index.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="test" class="com.example.servletjspdemo.web.MakeAmericaGreatAgain" scope="session" />
    </head>
    <body>
    	<!-- test -->
    	<% 
    		test.performGoodTest();
    		test.performBadTest();
    	%>
    	<center><img src="newicon1great50.png">
    	<h2>Sklep z papierosami</h2></center><hr>
        <center><h3>Zakupy</h3></center>
        <center>
        <btc><a href="addToBasket.jsp">Dodaj towar do koszyka</a></btc>
        <btc><a href="basket">Pokaż koszyk</a></btc>
        </center>
        
        <center><h3>Zarządzanie towarami</h3></center>
        <center>
        <btc><a href="obtainCigaretteData.jsp">Dodaj nowy towar</a></btc>
        <btc><a href="cigList">Pokaż wszystkie towary</a></btc>
        </center>
    </body>
</html>
