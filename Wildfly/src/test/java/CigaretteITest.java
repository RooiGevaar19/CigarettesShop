import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.restwsdemo.domain.Cigarette;
import com.example.restwsdemo.service.CigaretteManager;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.http.Status;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CigaretteITest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/wildfly/api";
	}
	
	
	@Inject
	CigaretteManager db = new CigaretteManager();

	
	@Test
	public void test01(){
		//delete("/person/").then().assertThat().statusCode(200);
		
		Cigarette cigarette = new Cigarette("Papierzosy", 14.88, 2137);
		

		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(cigarette).
	    when().
	    post("/cigarette/").then().assertThat().statusCode(is(201));
	} 
	
	@Test
	public void test02(){
		int a = db.getCount();
		db.addCigarette(new Cigarette("Papierzosy", 21.37, 2137));
		db.addCigarette(new Cigarette("Kiepy", 14.88, 1488));
		db.addCigarette(new Cigarette("Skrety", 9.11, 199));
		db.addCigarette(new Cigarette("Marlboro", 16.50, 3456));
		int b = db.getCount();
		
		assertEquals(b, a+4);
	} 
}
