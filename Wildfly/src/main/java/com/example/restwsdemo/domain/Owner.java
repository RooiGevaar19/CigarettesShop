package com.example.restwsdemo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Owner {
	private long id = 0;
	private String name = "";
	private String surname = "";
	private Collection<Cigarette> cigaretteList = new ArrayList<Cigarette>();
	
	public Owner () {
		
	}

	public Owner(long id, String name, String surname,
			List<Cigarette> cigaretteList) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cigaretteList = cigaretteList;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@ManyToMany
	public Collection<Cigarette> getCigaretteList() {
		return cigaretteList;
	}

	public void setCigaretteList(Collection<Cigarette> cigaretteList) {
		this.cigaretteList = cigaretteList;
	}
	
	
}