package com.example.servletjspdemo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.ShoppingBasket;
import com.example.servletjspdemo.service.CigaretteHandler;

@WebServlet("/removeCigarette")
public class DeleteCigarette extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=UTF-8");   
		CigaretteHandler storage = new CigaretteHandler();
	    storage.removeCigaretteByID(Integer.parseInt(request.getParameter("id")));
	    response.sendRedirect("removeSuccess.jsp");
	}
}
