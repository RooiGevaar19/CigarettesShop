package com.example.servletjspdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.servletjspdemo.domain.Cigarette;

public interface CigBase {
	List<Cigarette> getAllCigarettes();
	int addCigarette(Cigarette cig) throws SQLException, NumberFormatException;
	void removeCigarette(Cigarette cig) throws SQLException;
	void removeCigaretteByID(int id) throws SQLException;
	void removeAllCigarettes() throws SQLException;
	void replaceCigarette(Cigarette oldcig, Cigarette newcig) throws SQLException;
	void replaceCigarette(int oldcig_id, Cigarette newcig) throws SQLException;
	void editCigarette(int id, String name, double price, int count) throws SQLException, NumberFormatException;
	Cigarette getCigaretteByID(int ida) throws SQLException;
	void setAutoCommit(boolean e) throws SQLException;
	boolean getAutoCommit() throws SQLException;
	void TranBegin() throws SQLException;
	void TranCommit() throws SQLException;
	void TranRollback() throws SQLException;
	void TranEnd() throws SQLException; 
}
