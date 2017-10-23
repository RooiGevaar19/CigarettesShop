package com.example.servletjspdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Cigarette;

public class CigaretteHandler implements CigBase {
	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTableCig = "CREATE TABLE Cigarette(id INTEGER, Name VARCHAR(40), Price DECIMAL(8,2), Count INTEGER);";

	private PreparedStatement addCigStmt;
	private PreparedStatement deleteAllCigStmt;
	private PreparedStatement deleteCigStmt;
	private PreparedStatement getAllCigStmt;
	private PreparedStatement replaceCigStmt;

	private Statement statement;
	
	public CigaretteHandler() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Cigarette".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableCig);

			addCigStmt = connection.prepareStatement("INSERT INTO Cigarette(id, Name, Price, Count) VALUES (?, ?, ?, ?);");
			deleteAllCigStmt = connection.prepareStatement("DELETE FROM Cigarette;");
			deleteCigStmt = connection.prepareStatement("DELETE FROM Cigarette WHERE id = ?;");
			getAllCigStmt = connection.prepareStatement("SELECT id, Name, Price, Count FROM Cigarette;");
			getAllCigStmt = connection.prepareStatement("UPDATE Cigarette SET id = ?, Name = ?, Price = ?, Count = ? WHERE id = ?;");
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cigarette> getAllCigarettes() {
		List<Cigarette> cigs = new ArrayList<Cigarette>();

		try {
			ResultSet rs = getAllCigStmt.executeQuery();

			while (rs.next()) {
				Cigarette p = new Cigarette();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getDouble("Price"));
				p.setCount(rs.getInt("Count"));
				cigs.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cigs;
	}
	public int addCigarette(Cigarette cig) {
		int count = 0;
		try {
			addCigStmt.setInt(1, cig.getId());
			addCigStmt.setString(2, cig.getName());
			addCigStmt.setDouble(3, cig.getPrice());
			addCigStmt.setInt(4, cig.getCount());

			count = addCigStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public void removeCigarette(Cigarette cig) {
		try {
			deleteCigStmt.setInt(1, cig.getId());

			deleteCigStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeAllCigarettes() {
		try {
			deleteAllCigStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void replaceCigarette(Cigarette oldcig, Cigarette newcig) {
		try {
			replaceCigStmt.setInt(1, newcig.getId());
			replaceCigStmt.setString(2, newcig.getName());
			replaceCigStmt.setDouble(3, newcig.getPrice());
			replaceCigStmt.setInt(4, newcig.getCount());
			replaceCigStmt.setInt(4, oldcig.getId());
			
			addCigStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
