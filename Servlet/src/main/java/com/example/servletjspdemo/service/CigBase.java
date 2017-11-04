package com.example.servletjspdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.servletjspdemo.domain.Cigarette;

public interface CigBase {
	List<Cigarette> getAllCigarettes();
	int addCigarette(Cigarette cig);
	void removeCigarette(Cigarette cig);
	void removeCigaretteByID(int id);
	void removeAllCigarettes();
	void replaceCigarette(Cigarette oldcig, Cigarette newcig);
	void replaceCigarette(int oldcig_id, Cigarette newcig);
	void editCigarette(int id, String name, double price, int count);
	Cigarette getCigaretteByID(int ida) throws SQLException;
}
