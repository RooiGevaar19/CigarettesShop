package com.example.shdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.shdemo.domain.Buyer;
import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Cigarette;
import com.example.shdemo.domain.Person;

@Component
@Transactional
public class ShopManagerHibernate implements ShopManager {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addCigarette(Cigarette cigarette) {
		sessionFactory.getCurrentSession().persist(cigarette);
	}
	@Override
	public List<Cigarette> getAllCigarettes() {
		return sessionFactory.getCurrentSession().getNamedQuery("cigarette.all").list();
	}
	@Override
	public void deleteCigarette(Cigarette cigarette) {
		cigarette = (Cigarette) sessionFactory.getCurrentSession().get(Cigarette.class,
				cigarette.getID());
		
		// lazy loading here
		Buyer buyer = cigarette.getOwner();
		buyer.getCigs().remove(cigarette);
		sessionFactory.getCurrentSession().update(buyer);
		
		sessionFactory.getCurrentSession().delete(cigarette);
	}
	@Override
	public Cigarette findCigaretteByID(int id) {
		return (Cigarette) sessionFactory.getCurrentSession()
				.getNamedQuery("cigarette.byID")
				.setString("id", String.valueOf(id))
				.uniqueResult();
	}
	@Override
	public Cigarette findCigaretteByName(String name) {
		return (Cigarette) sessionFactory.getCurrentSession()
				.getNamedQuery("cigarette.byName")
				.setString("name", name)
				.uniqueResult();
	}
	
	@Override
	public void addBuyer(Buyer buyer) {
		sessionFactory.getCurrentSession().persist(buyer);
	}
	@Override
	public List<Buyer> getAllBuyers() {
		return sessionFactory.getCurrentSession().getNamedQuery("buyer.all").list();
	}
	@Override
	public void deleteBuyer(Buyer buyer) {
		buyer = (Buyer) sessionFactory.getCurrentSession().get(Buyer.class,
				buyer.getID());
		
		// lazy loading here
		for (Cigarette cigarette : buyer.getCigs()) {
			cigarette.setOwner(null);
			sessionFactory.getCurrentSession().update(cigarette);
		}
		sessionFactory.getCurrentSession().delete(buyer);
	}
	@Override
	public Buyer findBuyerByID(int id) {
		return (Buyer) sessionFactory.getCurrentSession()
				.getNamedQuery("buyer.byID")
				.setString("id", String.valueOf(id))
				.uniqueResult();
	}
	@Override
	public Buyer findBuyerByFirstName(String firstName) {
		return (Buyer) sessionFactory.getCurrentSession()
				.getNamedQuery("cigarette.byFirstName")
				.setString("fname", firstName)
				.uniqueResult();
	}
	@Override
	public Buyer findBuyerByLastName(String lastName) {
		return (Buyer) sessionFactory.getCurrentSession()
				.getNamedQuery("cigarette.byLastName")
				.setString("lname", lastName)
				.uniqueResult();
	}
}
