package com.example.servletjspdemo.domain;

public class Cigarette {
	private int id = 0;
	String Name = "";
	private double Price = 0.0;
	private int Count = 0;
	
	public Cigarette() {
		// TODO Auto-generated constructor stub
	}
	
	public Cigarette(int a, String b, double c, int d) {
		this.id = a;
		this.Name = b;
		this.Price = c;
		this.Count = d;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
	
	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	@Override
	public String toString() {
		return ""+Name+"\t"+Price+"\t"+Count+"";
	}
}
