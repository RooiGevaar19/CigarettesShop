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
		//get("/cigarette/delete/").then().assertThat().statusCode(is(201));
		
		
		Cigarette cigarette = new Cigarette("Papierzosy", 14.88, 2137);
		

		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(cigarette).
	    when().
	    post("/cigarette/").then().assertThat().statusCode(is(201));
	} 
	
	@Test
	public void test02(){
		//get("/cigarette/add/").then().assertThat().statusCode(is(201));
	} 
}
