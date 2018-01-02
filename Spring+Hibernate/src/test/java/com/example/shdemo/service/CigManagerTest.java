package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Buyer;
import com.example.shdemo.domain.Cigarette;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class CigManagerTest {

	@Autowired
	ShopManager shopManager;
	
	private final String TEST1_FirstName = "Janusz";
	private final String TEST1_LastName  = "Pawlak";

	private final String TEST2_FirstName = "Janusz";
	private final String TEST2_LastName  = "Pawlak";
	private final String TEST2_CigName   = "Papierzosy";
	private final double TEST2_CigPrice  = 21.37;
	private final int    TEST2_CigCount  = 2137;
	
	@Test
	public void addBuyerCheck() {
		Buyer buyer = new Buyer();
		buyer.setFirstName(TEST1_FirstName);
		buyer.setLastName(TEST1_LastName);
		
		shopManager.addBuyer(buyer);


		Buyer pewniak = shopManager.findBuyerByLastName(TEST1_LastName);

		assertEquals(TEST1_LastName, pewniak.getLastName());
		// ... check other properties here
	}

	@Test
	public void addCigaretteCheck() {
		Buyer buyer = new Buyer();
		buyer.setFirstName(TEST2_FirstName);
		buyer.setLastName(TEST2_LastName);
		
		int a = shopManager.getAllBuyers().size();
		shopManager.addBuyer(buyer);
		assertEquals(a+1, shopManager.getAllBuyers().size());
		assertEquals(0, buyer.getCigs().size());
		
		Cigarette cig = new Cigarette();
		cig.setName(TEST2_CigName);
		cig.setPrice(TEST2_CigPrice);
		cig.setCount(TEST2_CigCount);
		
		int b = shopManager.getCigarettesCount();
		shopManager.addCigarette(cig);
		assertEquals(b+1, shopManager.getCigarettesCount());
		
	}

	@Test
	public void disposeCigCheck() {
		Cigarette cig = shopManager.findCigaretteByName(TEST2_CigName);
		int b = shopManager.getCigarettesCount();
		shopManager.deleteCigarette(cig);
		assertEquals(b-1, shopManager.getCigarettesCount());
	}

}
