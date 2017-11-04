package com.example.servletjspdemo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.service.CigaretteHandler;

@WebServlet("/MakeAmericaGreatAgain")
public class MakeAmericaGreatAgain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CigaretteHandler storage = new CigaretteHandler();
		storage.removeAllCigarettes();
		storage.addCigarette(new Cigarette(1, "Marlboro", 16.00, 2137));
		storage.addCigarette(new Cigarette(2, "Chesterfield", 12.70, 1488));
		storage.addCigarette(new Cigarette(3, "Lucky Strike", 16.00, 1024));
		storage.addCigarette(new Cigarette(4, "LM", 14.70, 997));
		storage.addCigarette(new Cigarette(5, "Route 66", 12.50, 1540));
		storage.addCigarette(new Cigarette(6, "Skrety", 16.00, 0));
		storage.addCigarette(new Cigarette(7, "Rothmans", 11.99, 2666));
		response.sendRedirect("index.jsp");
	}
}
