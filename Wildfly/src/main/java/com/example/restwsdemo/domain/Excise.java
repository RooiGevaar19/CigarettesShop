package com.example.restwsdemo.domain;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "excise.all", query = "Select c from Excise c"),
	@NamedQuery(name = "excise.delete.all", query = "DELETE FROM Excise"),
	@NamedQuery(name = "excise.findByName", query = "SELECT c FROM Excise c WHERE c.name = :name"),
})
public class Excise {
	private long id = 0;
	private String name = "";
	private double value = 0.0;
	private Collection<Stamp> stamps;
	
	public Excise() {
		
	}
	
	public Excise(long id, String name, double value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}
	
	public Excise(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public Excise(long id, String name, double value, Collection<Stamp> stamps) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.stamps = stamps;
	}
	
	public Excise(String name, double value, Collection<Stamp> stamps) {
		super();
		this.name = name;
		this.value = value;
		this.stamps = stamps;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@OneToMany(mappedBy="excise", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	public Collection<Stamp> getStamps() {
		return stamps;
	}

	public void setStamps(Collection<Stamp> stamps) {
		this.stamps = stamps;
	}
}
