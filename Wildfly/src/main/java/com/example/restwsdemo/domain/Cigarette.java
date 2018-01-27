package com.example.restwsdemo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// https://github.com/KubaNeumann/restejbjpa/tree/master/src/main/java/com/example/restejbjpa/service
@XmlRootElement
@Entity
@NamedQueries({
		@NamedQuery(name = "cigarette.all", query = "Select c from Cigarette c"),
		@NamedQuery(name = "cigarette.delete.all", query = "DELETE FROM Cigarette"),
		@NamedQuery(name = "cigarette.findByName", query = "SELECT c FROM Cigarette c WHERE c.name = :name"),
		@NamedQuery(name = "cigarette.getCount", query = "SELECT COUNT(c) FROM Cigarette c")
})
public class Cigarette {
	private long id = 0;
	private String name = "";
	private double price = 0.0;
	private int count = 0;
	private Stamp stamp = new Stamp();
	private Collection<Owner> ownerList = new ArrayList<Owner>();
	
	public Cigarette() {
	}
	
	public Cigarette(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getID() {
		return id;
	}

	public void setID(long id) {
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

	@OneToOne(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	public Stamp getStamp() {
		return stamp;
	}

	public void setStamp(Stamp stamp) {
		this.stamp = stamp;
	}

	@ManyToMany(mappedBy="cigaretteList", fetch=FetchType.EAGER)
	@JsonIgnoreProperties("cigaretteList")
	public Collection<Owner> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(Collection<Owner> ownerList) {
		this.ownerList = ownerList;
	}
	
	public void addOwnerList(Collection<Owner> ownerList) {
		this.setOwnerList(ownerList);
		for (Owner owner : ownerList) {
			owner.getCigaretteList().add(this);
		}
	}
}
