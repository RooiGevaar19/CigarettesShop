package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "buyer.all", query = "Select p from Buyer p"),
	@NamedQuery(name = "buyer.byID", query = "Select p from Buyer p where p.id = :id"),
	@NamedQuery(name = "buyer.byfirstName", query = "Select p from Buyer p where p.firstname = :fname"),
	@NamedQuery(name = "buyer.bylastName", query = "Select p from Buyer p where p.lastname = :lname")
})
public class Buyer {
	private int id = 0;
	private String firstName;
	private String lastName;
	private Collection<Cigarette> cigs = new ArrayList<Cigarette>();
	
	public Buyer () {
		
	}

	public Buyer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Buyer(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Buyer(String firstName, String lastName,
			Collection<Cigarette> cigs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cigs = cigs;
	}
	
	public Buyer(int id, String firstName, String lastName,
			Collection<Cigarette> cigs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cigs = cigs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Collection<Cigarette> getCigs() {
		return cigs;
	}

	public void setCigs(Collection<Cigarette> cigs) {
		this.cigs = cigs;
	}
	
	
}
