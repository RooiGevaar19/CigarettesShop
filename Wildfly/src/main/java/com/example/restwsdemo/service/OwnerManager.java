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
import com.example.restwsdemo.domain.Owner;

@Stateless
public class OwnerManager {
	
	@PersistenceContext
	EntityManager em;

	public void addOwner(Owner cig) {
		em.persist(cig);
	}

	public void deleteOwner(int id){
		Owner cig = em.find(Owner.class, id);
		 
		em.remove(cig);
	}
	
	public Owner getOwner(int id) {
		return em.find(Owner.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> getAll(){
		return em.createNamedQuery("owner.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cigarette> findByName(int yop){
		return em.createNamedQuery("owner.findBySurname").setParameter("surname", yop).getResultList();
	}
	
	public void deleteAll(){
		em.createNamedQuery("owner.delete.all").executeUpdate();
	}
}
