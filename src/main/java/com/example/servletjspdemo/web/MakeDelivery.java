package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.ShoppingBasket;

@WebServlet("/makedelivery")
public class MakeDelivery extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
       
       PrintWriter out = response.getWriter();
       if (cigCount > 0) {
   	   out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<meta charset=\"UTF-8\">");
       out.println("<title>result</title>");
       out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
       out.println("</head>");
       out.println("<body>");
       out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
       out.println("<p><b>Nazwa:</b> "+cigName+"</p>");
       out.println("<p><b>Cena:</b> "+String.format("%.2f PLN", cigPrice)+"</p>");
       out.println("<p><b>Max ilosc:</b> "+cigCount+"</p>");
       out.println("<h2>Ile chcesz sztuk produktu?</h2>");
       out.println("<form action=\"addtobasket\" >\n" 
    		   +"<input type=\"hidden\" name=\"name\" value=\""+cigName+"\">\n" 
    		   +"<input type=\"hidden\" name=\"price\" value=\""+cigPrice+"\">\n"
    		   +"<input type=\"hidden\" name=\"count\" value=\""+cigCount+"\">\n"
    		   +"<input type=\"hidden\" name=\"id\" value=\""+cigID+"\">\n"
    		   +"<input type=\"number\" name=\"quantity\" value=\"1\" min=\"1\" max=\""+cigCount+"\">"
    		   +"<input type=\"submit\" value=\"Dodaj do koszyka\">\n" +
               	"</form>");
       out.println("<a href=\"addToBasket.jsp\">Powrot do koszyka</a><br>");
       out.println("<a href=\"index.jsp\">Strona glowna</a><br>");
       out.println("</body>");
       out.println("</html>");
       } else {
    	   out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<meta charset=\"UTF-8\">");
           out.println("<title>result</title>");
           out.println("<link href=\"index.css\" rel=\"stylesheet\" type=\"text/css\">");
           out.println("</head>");
           out.println("<body>");
           out.println("<center><img src=\"newicon1great50.png\"><h2>Sklep z papierosami</h2></center>");
           out.println("<center><h1>Produkt jest niedostepny. Sprobuj pozniej.</h1></center>");
           out.println("<hr>");
           out.println("<h2>Koszyk</h2>");
           out.println("<a href=\"addToBasket.jsp\">Kontynuuj dodawanie do koszyka</a><br>");
           out.println("<a href=\"basket\">Zobacz koszyk</a><br>");
           out.println("<a href=\"index.jsp\">Strona glowna</a><br>");
           out.println("</body>");
           out.println("</html>");
       }
       
	}
}
