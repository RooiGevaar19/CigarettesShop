package com.example.restwsdemo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CigarettesResponse {
	
	private List<Cigarette> cig;

	public List<Cigarette> getCigarette() {
		return cig;
	}

	public void setPerson(List<Cigarette> cig) {
		this.cig = cig;
	}

}
