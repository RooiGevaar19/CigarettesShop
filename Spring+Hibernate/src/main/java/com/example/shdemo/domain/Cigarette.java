package com.example.shdemo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "cigarette.all", query = "Select p from Cigarette p"),
	@NamedQuery(name = "cigarette.byID", query = "Select p from Cigarette p where p.id = :id"),
	@NamedQuery(name = "cigarette.byName", query = "Select p from Cigarette p where p.name = :name")
})
public class Cigarette {
	private int id;
	private String name;
	private double price;
	private int count;
	private Buyer owner;
	
	public Cigarette () {
		
	}
	
	public Cigarette(int id, String name, double price, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public Cigarette(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public Cigarette(String name, double price, int count, Buyer owner) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.owner = owner;
	}
	
	public Cigarette(int id, String name, double price, int count, Buyer owner) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.owner = owner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Buyer getOwner() {
		return owner;
	}

	public void setOwner(Buyer owner) {
		this.owner = owner;
	} 
	
	
}
