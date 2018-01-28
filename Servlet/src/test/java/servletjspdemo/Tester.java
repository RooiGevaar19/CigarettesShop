package servletjspdemo;


import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.validation.constraints.AssertTrue;
import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.servletjspdemo.domain.Cigarette;
import com.example.servletjspdemo.service.CigaretteHandler;



public class Tester {
	
	@Test
	public void conduct(){
		CigaretteHandler storage = new CigaretteHandler();
		
		// CREATE
		try {
			storage.TranBegin();
			storage.removeAllCigarettes();
			storage.addCigarette(new Cigarette(0, "Marlboro", 16.00, 2137));
			storage.addCigarette(new Cigarette(1, "Chesterfield", 12.70, 1488));
			storage.addCigarette(new Cigarette(2, "Lucky Strike", 16.00, 1024));
			storage.addCigarette(new Cigarette(3, "LM", 14.70, 997));
			storage.addCigarette(new Cigarette(4, "Route 66", 12.50, 1540));
			storage.addCigarette(new Cigarette(5, "Rothmans", 11.99, 2666));
			storage.addCigarette(new Cigarette(6, "Pall Mall", 11.80, 0));
			storage.TranCommit();
		} catch (SQLException | NumberFormatException e) {
			try {
				storage.TranRollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				storage.TranEnd();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		assertEquals(7, storage.getAllCigarettes().size());
	}
}
