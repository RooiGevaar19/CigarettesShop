package com.example.servletjspdemo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.service.CigaretteHandler;

@WebServlet("/MakeAmericaGreatAgain")
public class MakeAmericaGreatAgain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CigaretteHandler storage = new CigaretteHandler();
		try {
			storage.TranBegin();
			storage.removeAllCigarettes();
			storage.addCigarette(new Cigarette(1, "Marlboro", 16.00, 2137));
			storage.addCigarette(new Cigarette(2, "Chesterfield", 12.70, 1488));
			storage.addCigarette(new Cigarette(3, "Lucky Strike", 16.00, 1024));
			storage.addCigarette(new Cigarette(4, "LM", 14.70, 997));
			storage.addCigarette(new Cigarette(5, "Route 66", 12.50, 1540));
			storage.addCigarette(new Cigarette(6, "Skrety", 5.50, 0));
			storage.addCigarette(new Cigarette(7, "Rothmans", 11.99, 2666));
			storage.TranCommit();
		} catch (Exception e) {
			try {
				storage.TranRollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				storage.TranEnd();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.jsp");
		}
	}
	
	public void performGoodTest() {
		CigaretteHandler storage = new CigaretteHandler();
		try {
			storage.TranBegin();
			storage.removeAllCigarettes();
			storage.addCigarette(new Cigarette(0, "Marlboro", 16.00, 2137));
			storage.addCigarette(new Cigarette(1, "Chesterfield", 12.70, 1488));
			storage.addCigarette(new Cigarette(2, "Lucky Strike", 16.00, 1024));
			storage.addCigarette(new Cigarette(3, "LM", 14.70, 997));
			storage.addCigarette(new Cigarette(4, "Route 66", 12.50, 1540));
			storage.addCigarette(new Cigarette(5, "Skrety", 5.50, 0));
			storage.addCigarette(new Cigarette(6, "Rothmans", 11.99, 2666));
			storage.TranCommit();
			System.out.println("Test zakonczony sukcesem!");
		} catch (SQLException | NumberFormatException e) {
			try {
				storage.TranRollback();
				System.out.println("Test zakonczony niepowodzeniem!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				storage.TranEnd();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void performBadTest() {
		CigaretteHandler storage = new CigaretteHandler();
		try {
			storage.TranBegin();
			storage.addCigarette(new Cigarette(7, "Dadudely", 16.00, 2136));
			storage.addCigarette(new Cigarette(8, null, 16.00, 2136));
			storage.addCigarette(new Cigarette(9, "Papierzosy", 12.70, -1));
			storage.addCigarette(new Cigarette(10, "kiepy XD", -21.38, -2));
			storage.TranCommit();
			System.out.println("Test zakonczony sukcesem!");
		} catch (SQLException | NumberFormatException e) {
			try {
				storage.TranRollback();
				System.out.println("Test zakonczony niepowodzeniem!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				storage.TranEnd();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
