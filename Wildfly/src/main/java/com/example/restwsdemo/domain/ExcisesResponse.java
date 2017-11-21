package com.example.restwsdemo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExcisesResponse {
	
	private List<Excise> cig;

	public List<Excise> getExcise() {
		return cig;
	}

	public void setExcise(List<Excise> cig) {
		this.cig = cig;
	}

}
