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
		
		for (Cigarette i : cigdb.getAllCigarettes()) {
			out.println(""+i.toString()+"<br/>");
		}
	}
}
