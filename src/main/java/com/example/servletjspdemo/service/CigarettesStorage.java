package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Cigarette;


public class CigarettesStorage {
	private List<Cigarette> db = new ArrayList<Cigarette>();
	
	public void insert(Cigarette cigarette){
		Cigarette newCigarette = new Cigarette(cigarette.getId(), cigarette.getName(), cigarette.getPrice(), cigarette.getCount());
		db.add(newCigarette);
	}
	
	public List<Cigarette> selectAllCigarettes(){
		return db;
	}
}
