package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/newform")
public class NewFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Wypelnij dane</h2>" +
				"<form action='newdata'>" +
				"Imie: <input type='text' name='Name' /> <br />" +
				"Nazwisko: <input type='text' name='Surname' /> <br /><br/>" +
				"Data urodzenia (miesiac, dzien, rok): <br />"
				+ "<input type='number' name='Month' min='1' max='12' width=128 value='4'/>"
				+ "<input type='number' name='Day' min='1' max='31' width=128 value='2'/>"
				+ "<input type='number' name='Year' min='1848' max='2137' width=128 value='2005'/> <br /><br/>" +
				"Plec:<br/><input type='radio' name='gender' value='male' checked>Mezczyzna<br />"+
				  "<input type='radio' name='gender' value='female'>Kobieta<br />"+
				  "<input type='radio' name='gender' value='other'>Inna<br />"+ 
				"<br/>Kraj:<br /><select name='country'>" +
				  "<option value='poland' selected='selected'>Polska</option>" +
				  "<option value='germany'>Niemcy</option>" +
				  "<option value='usa'>USA</option>" +
				  "<option value='israel'>Izrael</option>" +
				  "<option value='uk'>Wielka Brytania</option>" +
				  "<option value='czech'>Czechy</option>" +
				  "<option value='japan'>Japonia</option>" +
				"</select><br /><br/>Twoje hobby:<br/>" +
				"<input type='checkbox' name='hobby' value='bicycle'>Lubie jezdzic na rowerze<br />" +
				"<input type='checkbox' name='hobby' value='tv'>Lubie ogladac telewizje<br />" +
				"<input type='checkbox' name='hobby' value='cs'>Lubie grac w CSa<br />" +
				"<input type='checkbox' name='hobby' value='beer'>Lubie pic piwo<br />" +
				"<input type='checkbox' name='hobby' value='books'>Lubie czytac ksiazki.<br />" +
				"<br/>Opinia:<br/>"+
				"<textarea name='message' rows='10' cols='30'>" +
				"Wyraz swoja opinie tutaj." +
				"</textarea><br />" +
				"<input type='submit' value='Zatwierdz' />" +
				"</form>" +
				"</body></html>");
		out.close();
		
	}
}
