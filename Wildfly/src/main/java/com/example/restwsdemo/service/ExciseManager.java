package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Excise;

@Stateless
public class ExciseManager {
	
	@PersistenceContext
	EntityManager em;

	public void addExcise(Excise cig) {
		em.persist(cig);
	}

	public void deleteExcise(int id){
		Excise cig = em.find(Excise.class, id);
		 
		em.remove(cig);
	}
	
	public Excise getExcise(int id) {
		return em.find(Excise.class, id);
	}
	
//	public List<Cigarette> getAllCigarettes(){
//		return db;
//	}

}
