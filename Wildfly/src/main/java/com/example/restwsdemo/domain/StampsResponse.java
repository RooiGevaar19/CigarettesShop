package com.example.restwsdemo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampsResponse {
	
	private List<Stamp> cig;

	public List<Stamp> getStamp() {
		return cig;
	}

	public void setStamp(List<Stamp> cig) {
		this.cig = cig;
	}

}
