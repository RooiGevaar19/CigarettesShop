package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.restwsdemo.domain.Cigarette_;
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
	
	@SuppressWarnings("unchecked")
	public List<Cigarette> getAll(){
		return em.createNamedQuery("cigarette.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cigarette> findByName(int yop){
		return em.createNamedQuery("cigarette.findByName").setParameter("name", yop).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cigarette> findCigarette(int yop){
		return em.createNamedQuery("cigarette.findByName").setParameter("name", yop).getResultList();
	}
	
	public int getCount(){
		return (int) em.createNamedQuery("cigarette.getCount").getSingleResult();
	}
	
	public void deleteAll(){
		em.createNamedQuery("cigarette.delete.all").executeUpdate();
	}
	
	public List<Cigarette> getByName(String name) {
		// easy
		//return em.createNamedQuery("Cigarette.findByName").setParameter("name", name).getResultList();
		
		// hard
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Cigarette> c = qb.createQuery(Cigarette.class);
		
		Root<Cigarette> b = c.from(Cigarette.class);
		
		Predicate cond1 = qb.equal(b.get(Cigarette_.name), name);
		c.where(cond1);
		
		TypedQuery<Cigarette> q = em.createQuery(c);
		
		List<Cigarette> result = q.getResultList();
		return result;
	}
	
}
