package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Buyer;
import com.example.shdemo.domain.Cigarette;

public interface ShopManager {
	void addCigarette(Cigarette cigarette);
	List<Cigarette> getAllCigarettes();
	void deleteCigarette(Cigarette cigarette);
	Cigarette findCigaretteByID(int id);
	Cigarette findCigaretteByName(String name);
	
	void addBuyer(Buyer buyer);
	List<Buyer> getAllBuyers();
	void deleteBuyer (Buyer buyer);
	Buyer findBuyerByID(int id);
	Buyer findBuyerByFirstName(String firstName);
	Buyer findBuyerByLastName(String lastName);
}
