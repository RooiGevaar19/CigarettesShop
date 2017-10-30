package com.example.servletjspdemo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.OverridesAttribute.List;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.domain.Delivery;
import com.example.servletjspdemo.domain.ShoppingBasket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addtobasket")
public class AddToBasket extends HttpServlet {
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

        
          String cigName = request.getParameter("name");
          Double cigPrice = Double.parseDouble(request.getParameter("price"));
          int cigCount = Integer.parseInt(request.getParameter("count"));
          int cigID = Integer.parseInt(request.getParameter("id"));
          int cigQuantity = Integer.parseInt(request.getParameter("quantity"));
          
        if (cigCount > 0) {
        	shoppingBasket.addToBasket(cigID, new Delivery(new Cigarette(cigID, cigName, cigPrice, cigCount), cigQuantity));
        	response.sendRedirect("AddSuccess");
        } else {
        	response.sendRedirect("AddFail");
        }
	}
	
}
