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
import com.example.restwsdemo.domain.Excise;

@Stateless
public class ExciseManager {
	
	@PersistenceContext
	EntityManager em;

	public void addExcise(Excise cig) {
		em.persist(cig);
	}

	public void deleteExcise(long id){
		Excise cig = em.find(Excise.class, id);
		 
		em.remove(cig);
	}
	
	public Excise getExcise(long id) {
		return em.find(Excise.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Excise> getAll(){
		return em.createNamedQuery("excise.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Excise> findByName(int yop){
		return em.createNamedQuery("excise.findByName").setParameter("name", yop).getResultList();
	}
	
	public void deleteAll(){
		em.createNamedQuery("excise.delete.all").executeUpdate();
	}
}
