package com.example.springdemo.domain;

public class Person {
	
	private String firstName = "Jan";
	private int yob = 1945;
	private Parents parents;
	private Children children;
	
	public Person() {
		
	}
	
	public Person(String firstName, int yob, Parents parents, Children children) {
		super();
		this.firstName = firstName;
		this.yob = yob;
		this.parents = parents;
		this.children = children;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	
	public Parents getParents() {
		return parents;
	}
	public void setParents(Parents parents) {
		this.parents = parents;
	}
	public Children getChildren() {
		return children;
	}
	public void setChildren(Children children) {
		this.children = children;
	}
}
