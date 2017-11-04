package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/newdata")
public class NewDataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String therearetwogenders = "Jesteś ";
		if ("male".equals(request.getParameter("gender"))) therearetwogenders += "mezczyzną.";
		if ("female".equals(request.getParameter("gender"))) therearetwogenders += "kobietą.";
		if ("other".equals(request.getParameter("gender"))) therearetwogenders += "jedną z pozostałych 69 płci. XD";
		
		String land = "";
		if ("poland".equals(request.getParameter("country"))) land += "Polska";
		if ("germany".equals(request.getParameter("country"))) land += "Niemcy";
		if ("usa".equals(request.getParameter("country"))) land += "USA";
		if ("israel".equals(request.getParameter("country"))) land += "Izrael";
		if ("uk".equals(request.getParameter("country"))) land += "Wielka Brytania";
		if ("czech".equals(request.getParameter("country"))) land += "Czechy";
		
		String selectedHobby = "";
		if (request.getParameterValues("hobby").length > 0) {
			selectedHobby = "Lubisz";
			for (String hobby : request.getParameterValues("hobby")) {
				//selectedHobby += hobby + " ";
				if ("bicycle".equals(hobby)) selectedHobby += " jeździć na rowerze,";
				if ("tv".equals(hobby)) selectedHobby += " oglądać telewizję,";
				if ("cs".equals(hobby)) selectedHobby += " grać w Counter Strike,";
				if ("beer".equals(hobby)) selectedHobby += " pić piwo,";
				if ("books".equals(hobby)) selectedHobby += " czytać książki,";
			}
			selectedHobby = "" + selectedHobby.substring(0, selectedHobby.length() - 1) + ".";
		} else {
			selectedHobby = "Nic nie lubisz.";
		}
		
		String data_ur = "Twoja data urodzenia ";
		try {
			int m = Integer.parseInt(request.getParameter("Month"));
			int d = Integer.parseInt(request.getParameter("Day"));
			int y = Integer.parseInt(request.getParameter("Year"));
			if (
					(
						(m == 1 && d <= 31)
                        ||(m == 2 && (
                        		(y % 4 != 0 && d <= 28)
                        		||(y % 4 == 0 && y % 400 != 0 && d <= 28)
                                ||(y % 4 == 0 && y % 400 == 0 && d <= 29)
                        		)
                        )
                        ||(m == 3 && d <= 31)
                        ||(m == 4 && d <= 30)
                        ||(m == 5 && d <= 31)
                        ||(m == 6 && d <= 30)
                        ||(m == 7 && d <= 31)
                        ||(m == 8 && d <= 31)
                        ||(m == 9 && d <= 30)
                        ||(m == 10 && d <= 31)
                        ||(m == 11 && d <= 30)
                        ||(m == 12 && d <= 31)
					)
					//&& (h <= 23) && (mi <= 59) && (s <= 60) && (h >= 0) && (mi >= 0) && (s >= 0)
				) {
				data_ur += "to ";
				data_ur += d + " ";
				switch (m) {
					case 1 : data_ur += "stycznia "; break;
					case 2 : data_ur += "lutego "; break;
					case 3 : data_ur += "marca "; break;
					case 4 : data_ur += "kwietnia "; break;
					case 5 : data_ur += "maja "; break;
					case 6 : data_ur += "czerwca "; break;
					case 7 : data_ur += "lipca "; break;
					case 8 : data_ur += "sierpnia "; break;
					case 9 : data_ur += "września "; break;
					case 10 : data_ur += "października "; break;
					case 11 : data_ur += "listopada "; break;
					case 12 : data_ur += "grudnia "; break;
					//default : throw new Exception();
				}
				data_ur += y + " r.";
			} else {
				data_ur += "nie jest poprawną datą.";
			}
		} catch (Exception e) {
			data_ur += "jest nieprawidłowa - prawdopodobnie wartości miesiąca/dnia/roku nie są numeryczne.";
		}
		
		//if (request.getParameter("country")) ;
		
		out.println("<html><body><h2>Twoje dane:</h2>" +
				"Imię i nazwisko: "+request.getParameter("Name")+" "+request.getParameter("Surname")+"<br/>" +
				""+therearetwogenders+"<br/>"+
				""+data_ur+"<br/>"+
				"Twój kraj to "+land+".<br/>"+
				"" + selectedHobby + "<br />" +
				"Twoja opinia: " + request.getParameter("message") + "<br />" +
				"</body></html>");
	}
}
