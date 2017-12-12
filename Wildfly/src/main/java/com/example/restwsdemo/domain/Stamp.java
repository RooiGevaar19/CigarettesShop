package com.example.restwsdemo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "stamp.all", query = "Select c from Stamp c"),
	@NamedQuery(name = "stamp.delete.all", query = "DELETE FROM Stamp"),
	@NamedQuery(name = "stamp.findByDate", query = "SELECT c FROM Stamp c WHERE c.date = :date"),
})
public class Stamp {
	private long id = 0;
	private String date = "";
	private Excise excise = new Excise();
	
	public Stamp() {
		
	}

	public Stamp(long id, String date, Excise excise) {
		super();
		this.id = id;
		this.date = date;
		this.excise = excise;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Excise getExcise() {
		return excise;
	}

	public void setExcise(Excise excise) {
		this.excise = excise;
	}
	
	public void addExcise(Excise excise) {
		setExcise(excise);
		excise.getStamps().add(this);
	}
	
}
