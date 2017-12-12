package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Stamp;

@Stateless
public class StampManager {
	
	@PersistenceContext
	EntityManager em;

	public void addStamp(Stamp cig) {
		em.persist(cig);
	}

	public void deleteStamp(int id){
		Stamp cig = em.find(Stamp.class, id);
		 
		em.remove(cig);
	}
	
	public Stamp getStamp(int id) {
		return em.find(Stamp.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Stamp> getAll(){
		return em.createNamedQuery("stamp.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Stamp> findByDate(int yop){
		return em.createNamedQuery("stamp.findByDate").setParameter("date", yop).getResultList();
	}
	
	public void deleteAll(){
		em.createNamedQuery("stamp.delete.all").executeUpdate();
	}
}
