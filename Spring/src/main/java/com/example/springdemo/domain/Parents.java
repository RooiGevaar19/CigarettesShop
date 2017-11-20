package com.example.springdemo.domain;

public class Parents {
	private Person father;
	private Person mother;
	
	public Parents(Person father, Person mother) {
		super();
		this.father = father;
		this.mother = mother;
	}
	
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
}
