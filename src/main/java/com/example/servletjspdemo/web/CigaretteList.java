package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.service.CigarettesStorage;

@WebServlet(urlPatterns = "/cigList")
public class CigaretteList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		CigarettesStorage cigdb = new CigarettesStorage();
		cigdb.insert(new Cigarette(1, "Marlboro", 15.50, 2137));
		cigdb.insert(new Cigarette(2, "Pallmall", 12.00, 1488));
		cigdb.insert(new Cigarette(3, "West", 14.20, 911));
		cigdb.insert(new Cigarette(4, "LM", 13.70, 997));
		cigdb.insert(new Cigarette(5, "Route 66", 12.50, 2287));
		
		for (Cigarette i : cigdb.selectAllCigarettes()) {
			out.println(""+i.toString()+"<br/>");
		}
	}
}
