package com.example.servletjspdemo.service;

import java.util.List;

import com.example.servletjspdemo.domain.Cigarette;

public interface CigBase {
	List<Cigarette> getAllCigarettes();
	int addCigarette(Cigarette cig);
	void removeCigarette(Cigarette cig);
	void removeAllCigarettes();
	void replaceCigarette(Cigarette oldcig, Cigarette newcig);
	void replaceCigarette(int oldcig_id, Cigarette newcig);
}
