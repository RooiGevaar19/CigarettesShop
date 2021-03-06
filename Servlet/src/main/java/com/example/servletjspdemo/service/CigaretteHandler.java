package com.example.servletjspdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.example.servletjspdemo.domain.Cigarette;

public class CigaretteHandler implements CigBase {
	private Connection connection;

	private String url = "jdbc:postgresql://127.0.0.1:5432/javaee";

	private String createTableCig = "CREATE TABLE Cigarette(id SERIAL, Name VARCHAR(40) NOT NULL, Price DECIMAL(8,2) CHECK (Price >= 0.0), Count INTEGER CHECK (Count >= 0), PRIMARY KEY(id));";

	private String getAllCigStmt = "SELECT id, Name, Price, Count FROM Cigarette;";
	
	protected PreparedStatement addCigStmt;
	protected PreparedStatement deleteAllCigStmt;
	protected PreparedStatement deleteCigStmt;
	protected PreparedStatement replaceCigStmt;
	protected PreparedStatement getCigByIDStmt;

	private Statement statement;
	
	public CigaretteHandler() {
		try {
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","postgres");
			connection = DriverManager.getConnection(url, props);
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

			addCigStmt = connection.prepareStatement("INSERT INTO Cigarette(Name, Price, Count) VALUES (?, ?, ?);");
			deleteAllCigStmt = connection.prepareStatement("DELETE FROM Cigarette;");
			deleteCigStmt = connection.prepareStatement("DELETE FROM Cigarette WHERE id = ?;");
			replaceCigStmt = connection.prepareStatement("UPDATE Cigarette SET Name = ?, Price = ?, Count = ? WHERE id = ?;");
			getCigByIDStmt = connection.prepareStatement("SELECT id, Name, Price, Count FROM Cigarette WHERE id = ?;");
			//System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cigarette> getAllCigarettes() {
		List<Cigarette> cigs = new ArrayList<Cigarette>();

		try {
			ResultSet rs = statement.executeQuery(getAllCigStmt);

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
	public int addCigarette(Cigarette cig) throws SQLException, NumberFormatException {
		int count = 0;
		addCigStmt.setString(1, cig.getName());
		addCigStmt.setDouble(2, cig.getPrice());
		addCigStmt.setInt(3, cig.getCount());

		count = addCigStmt.executeUpdate();
		return count;
	}
	public void removeCigarette(Cigarette cig) throws SQLException {
		deleteCigStmt.setInt(1, cig.getId());
		deleteCigStmt.executeUpdate();

	}
	public void removeCigaretteByID(int id) throws SQLException {
		deleteCigStmt.setInt(1, id);
		deleteCigStmt.executeUpdate();
	}
	public void removeAllCigarettes() throws SQLException {
		deleteAllCigStmt.executeUpdate();
	}
	
	public void replaceCigarette(Cigarette oldcig, Cigarette newcig) throws SQLException {
		replaceCigStmt.setString(1, newcig.getName());
		replaceCigStmt.setDouble(2, newcig.getPrice());
		replaceCigStmt.setInt(3, newcig.getCount());
		replaceCigStmt.setInt(4, oldcig.getId());
			
		addCigStmt.executeUpdate();
	}
	
	public void replaceCigarette(int oldcig_id, Cigarette newcig) throws SQLException {
		replaceCigStmt.setString(1, newcig.getName());
		replaceCigStmt.setDouble(2, newcig.getPrice());
		replaceCigStmt.setInt(3, newcig.getCount());
		replaceCigStmt.setInt(4, oldcig_id);
			
		replaceCigStmt.executeUpdate();
	}
	
	public void editCigarette(int id, String name, double price, int count) throws SQLException, NumberFormatException {
		replaceCigStmt.setString(1, name);
		replaceCigStmt.setDouble(2, price);
		replaceCigStmt.setInt(3, count);
		replaceCigStmt.setInt(4, id);
			
		replaceCigStmt.executeUpdate();
	}
	
	public Cigarette getCigaretteByID(int ida) throws SQLException {
		Cigarette p = new Cigarette();
		getCigByIDStmt.setInt(1, ida);

		ResultSet rs = getCigByIDStmt.executeQuery();
		
		rs.next();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("Name"));
		p.setPrice(rs.getDouble("Price"));
		p.setCount(rs.getInt("Count"));
			
		return p;
	}
	
	public void setAutoCommit(boolean e) throws SQLException {
		connection.setAutoCommit(e);
	}
	public boolean getAutoCommit() throws SQLException {
		return connection.getAutoCommit();
	}
	public void TranBegin() throws SQLException {
		setAutoCommit(false);
	}
	public void TranCommit() throws SQLException {
		connection.commit();
	}
	public void TranRollback() throws SQLException {
		connection.rollback();
	}
	public void TranEnd() throws SQLException {
		setAutoCommit(true);
	}

}
