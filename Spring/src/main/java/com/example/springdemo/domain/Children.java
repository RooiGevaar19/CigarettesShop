package com.example.springdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class Children {
	private List<Person> children = new ArrayList<Person>();

	public Children(List<Person> children) {
		super();
		this.children = children;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}
}
