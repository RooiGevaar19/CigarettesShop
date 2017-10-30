package com.example.servletjspdemo.web;

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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/basket")
public class Shop extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {

    	//httpServletResponse.setCharacterEncoding("text/html;charset=UTF-8");
    	PrintWriter out = httpServletResponse.getWriter();
        HttpSession session = httpServletRequest.getSession();
        

        try {
        	double sum = 0.0;
        	ShoppingBasket shoppingBasket;
            shoppingBasket = (ShoppingBasket) session.getAttribute("basket");
            Map<Integer, Delivery> items = shoppingBasket.getBasketItems();
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>result</title>");
            out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
            out.println("<hr>");
            out.println("<h3>Twój koszyk</h3>");
            out.println("<table>");
        	out.println("<th>Nazwa</th> <th>Cena za sztuke</th> <th>Ilosc</th> <th>Cena ogolem</th> <th>Akcje</th>\n");
        	for(Integer key: items.keySet()){
        		out.println("<tr><td>"+items.get(key).getCigarette().getName()
        				   +"</td><td>"+String.format("%.2f PLN", items.get(key).getCigarette().getPrice())
        				   +"</td><td>"+items.get(key).getQuantity()
        				   +"</td><td>"+String.format("%.2f PLN", ((items.get(key).getCigarette().getPrice())*(items.get(key).getQuantity())))
        				   +"</td><td>"
        				   +"<form action=\"removefrombasket\"><input type=\"hidden\" name=\"ida\" value=\""+key+"\"><input type=\"submit\" value=\"Usun\"></form>"
        				   + "</td></tr>");
        		sum += ((items.get(key).getCigarette().getPrice())*(items.get(key).getQuantity()));
        	}
        	out.println("</table>");
        	out.println("<h3>Suma do zaplaty: "+String.format("%.2f PLN", sum)+"</h3>");
        	//out.println("<form action=\"makeTran\" style=\"margin-bottom:0.2in\"><input type=\"submit\" value=\"Wykonaj zakup\"></form>");
        	out.println("<btl><a href=\"makeTran\">Dokonaj zakupu</a></btl>");
        	out.println("<btl><a href=\"addToBasket.jsp\">Dodaj wiecej produktow</a></btl>");
        	out.println("<btl><a href=\"index.jsp\">Wstecz</a></btl>");
        	out.println("</body>");
        	out.println("</html>");
        } catch (NullPointerException e) {
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>result</title>");
            out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
            out.println("<hr>");
            out.println("<center><h3>Twój koszyk jest pusty!</h3></center>");
            out.println("<center><btc><a href=\"index.jsp\">Wstecz</a></btc></center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}