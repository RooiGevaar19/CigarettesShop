package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Buyer {
	private int id = 0;
	private String firstName;
	private String lastName;
	private Collection<Cigarette> cigs = new ArrayList<Cigarette>();
	
	public Buyer () {
		
	}

	public Buyer(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Buyer(int id, String firstName, String lastName,
			Collection<Cigarette> cigs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cigs = cigs;
	}

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

	public Collection<Cigarette> getCigs() {
		return cigs;
	}

	public void setCigs(Collection<Cigarette> cigs) {
		this.cigs = cigs;
	}
	
	
}
