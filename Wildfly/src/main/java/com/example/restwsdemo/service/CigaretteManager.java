package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Cigarette;

@Stateless
public class CigaretteManager {
	
	@PersistenceContext
	EntityManager em;

	public void addCigarette(Cigarette cig) {
		em.persist(cig);
	}

	public void deleteCigarette(int id){
		Cigarette cig = em.find(Cigarette.class, id);
		 
		em.remove(cig);
	}
	
	public Cigarette getCigarette(int id) {
		return em.find(Cigarette.class, id);
	}
	
//	public List<Cigarette> getAllCigarettes(){
//		return db;
//	}

}
