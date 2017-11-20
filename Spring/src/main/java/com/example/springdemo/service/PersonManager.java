package com.example.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springdemo.domain.Person;

@Component
public class PersonManager {

	@Autowired
	private List<Person> persons = new ArrayList<Person>();

	public String sayName() {
		String a = "";
		for (Person person : persons) {
			a += "I'm " + person.getFirstName() + "!\n";
		}
		return a;
	}
	
	public int getCount() {
		return persons.size();
	}

}
