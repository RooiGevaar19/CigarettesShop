package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.service.CigaretteHandler;
import com.example.servletjspdemo.service.CigarettesStorage;

@WebServlet(urlPatterns = "/cigList")
public class CigaretteList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		CigaretteHandler cigdb = new CigaretteHandler();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>result</title>");
        out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
        out.println("<hr>");
		out.println("<h3>Dostępne produkty:</h3>");
		out.println("<table>");
		out.println("<th>Nazwa</th> <th>Cena</th> <th>Dostęność w sztukach</th> <th>Akcje</th>\n");
		
		for (Cigarette i : cigdb.getAllCigarettes()) {
			out.println("<tr><td>"+i.getName()
					+"</td><td>"+String.format("%.2f PLN", i.getPrice())
					+"</td><td>"+i.getCount()
					+"</td><td>"
					+"<form action=\"obtainEditedData.jsp\" style=\"display:inline\">"
						+"<input type=\"hidden\" name=\"id\" value=\""+i.getId()+"\">"
						+"<input type=\"hidden\" name=\"name\" value=\""+i.getName()+"\">"
						+"<input type=\"hidden\" name=\"price\" value=\""+i.getPrice()+"\">"
						+"<input type=\"hidden\" name=\"count\" value=\""+i.getCount()+"\">"
						+"<input type=\"submit\" value=\"Edytuj\"></form>"
					+"<form action=\"removeRecord.jsp\" style=\"display:inline\" method=\"get\">"
						+"<input type=\"hidden\" name=\"id\" value=\""+i.getId()+"\">"
						+"<input type=\"hidden\" name=\"name\" value=\""+i.getName()+"\">"
						+"<input type=\"hidden\" name=\"price\" value=\""+i.getPrice()+"\">"
						+"<input type=\"hidden\" name=\"count\" value=\""+i.getCount()+"\">"
						+"<input type=\"submit\" value=\"Usuń\"></form>"
					+"</td></tr>");
		}
		out.println("</table>");
		out.println("<btl><a href=\"obtainCigaretteData.jsp\">Dodaj</a></btl>");
		out.println("<btl><a href=\"index.jsp\">Menu główne</a></btl>");
		out.println("</body>");
		out.println("</html>");
	}
}
