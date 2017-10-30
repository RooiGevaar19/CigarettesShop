package com.example.servletjspdemo.domain;

public class Delivery {
	private Cigarette cig;
	private int quantity;
	
	public Delivery(Cigarette cig, int quantity) {
		this.cig = cig;
		this.quantity = quantity;
	}
	
	public Cigarette getCigarette() {
		return cig;
	}
	public void setCigarette(Cigarette cig) {
		this.cig = cig;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
