package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TranFail")
public class TranFail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
        out.println("<center><h1>Zakup nie powiodl sie!</h1></center>");
        out.println("<hr>");
        out.println("<a href=\"basket\">Koszyk</a><br>");
        out.println("<a href=\"index.jsp\">Strona glowna</a><br>");
        out.println("</body>");
        out.println("</html>");
	}
}
