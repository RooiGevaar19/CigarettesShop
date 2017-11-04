package com.example.servletjspdemo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.domain.Delivery;
import com.example.servletjspdemo.domain.ShoppingBasket;

@WebServlet("/removefrombasket")
public class DeleteFromBasket extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=UTF-8");
	    HttpSession session = request.getSession();
	    ShoppingBasket shoppingBasket = (ShoppingBasket) session.getAttribute("basket");


	    if (shoppingBasket == null) {
	        shoppingBasket = new ShoppingBasket();
	        session.setAttribute("basket", shoppingBasket);
	    }

	    
	    int cigID = Integer.parseInt(request.getParameter("ida"));

	    shoppingBasket.removeFromBasket(cigID);
	    response.sendRedirect("basket");

	}
}
