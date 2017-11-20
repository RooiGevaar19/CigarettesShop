package com.example.springdemo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PersonManagerTest {

	@Autowired
	private PersonManager pm;

	@Test
	public void sayHelloTest() {
		String control = "I'm Zosia!\nI'm Janusz!\nI'm Grazyna!\nI'm Roman!\nI'm Halina!\nI'm Brajan!\nI'm Dzesika!\nI'm Seba!\nI'm Karyna!\nI'm Dzoana!\n";
		assertEquals(control, pm.sayName());
		//assertEquals(10, pm.getCount());
	}

}
