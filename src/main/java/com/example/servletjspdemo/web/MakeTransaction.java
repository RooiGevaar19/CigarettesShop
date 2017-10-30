package com.example.servletjspdemo.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.domain.Delivery;
import com.example.servletjspdemo.domain.ShoppingBasket;
import com.example.servletjspdemo.service.CigaretteHandler;

@WebServlet("/makeTran")
public class MakeTransaction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ShoppingBasket shoppingBasket = (ShoppingBasket) session.getAttribute("basket");


        if (shoppingBasket != null) {
        	Map<Integer, Delivery> items = shoppingBasket.getBasketItems();
        	CigaretteHandler db = new CigaretteHandler();
        	int flag = 1;
        	for (Integer key : items.keySet()) {
        		if (((items.get(key).getCigarette().getCount())-(items.get(key).getQuantity())) < 0) {
        			flag = 0;
        		}
        	}
        	if (flag == 0) {
        		response.sendRedirect("TranFail");
        	} else {
        		for (Integer key : items.keySet()) {
        			Cigarette newcig = new Cigarette(
						items.get(key).getCigarette().getId(),
						items.get(key).getCigarette().getName(),
						items.get(key).getCigarette().getPrice(),
						((items.get(key).getCigarette().getCount())-(items.get(key).getQuantity()))
        			);
        			db.replaceCigarette(items.get(key).getCigarette().getId(), newcig);
        		}
        		items.clear();
        		response.sendRedirect("TranSuccess");
        	}
        } else {
        	response.sendRedirect("TranFail");
        }
		
	}
}
