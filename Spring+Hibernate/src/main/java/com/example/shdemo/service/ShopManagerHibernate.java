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
		person = (Person) sessionFactory.getCurrentSession().get(Person.class,
				person.getId());
		car = (Car) sessionFactory.getCurrentSession().get(Car.class,
				car.getId());

		Car toRemove = null;
		// lazy loading here (person.getCars)
		for (Car aCar : person.getCars())
			if (aCar.getId().compareTo(car.getId()) == 0) {
				toRemove = aCar;
				break;
			}

		if (toRemove != null)
			person.getCars().remove(toRemove);

		car.setSold(false);
	}
	@Override
	public Cigarette findCigaretteByID(int id) {
		
	}
	@Override
	public Cigarette findCigaretteByName(String name) {
		
	}
	
	@Override
	public void addBuyer(Buyer buyer) {
		
	}
	@Override
	public List<Buyer> getAllBuyers() {
		
	}
	@Override
	public void deleteBuyer(Buyer buyer) {
		
	}
	@Override
	public Buyer findBuyerByID(int id) {
		
	}
	@Override
	public Buyer findBuyerByLastName(String lastName) {
		
	}
	
	public List<Cigarette> getOwnedCigarettes(Buyer buyer) {
		
	}
}
