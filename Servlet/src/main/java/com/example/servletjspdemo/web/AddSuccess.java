package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Cigarette;

@WebServlet("/AddSuccess")
public class AddSuccess extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setCharacterEncoding("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>result</title>");
        out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
        out.println("<hr>");
        out.println("<center><h1>Produkt zostal dodany do twojego koszyka</h1></center>");
        out.println("<hr>");
        out.println("<center><btc><a href=\"addToBasket.jsp\">Kontynuuj dodawanie do koszyka</a></btc>");
        out.println("<btc><a href=\"basket\">Zobacz koszyk</a></btc>");
        out.println("<btc><a href=\"index.jsp\">Strona glowna</a></btc></center>");
        out.println("</body>");
        out.println("</html>");
	}

}
