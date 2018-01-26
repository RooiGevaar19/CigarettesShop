import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restwsdemo.domain.Cigarette;
import com.jayway.restassured.RestAssured;


public class CigaretteITest {
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/wildfly/api";
	}

	
//	@Test
//	public void addCigarette(){
//		//delete("/person/").then().assertThat().statusCode(200);
//		
//		Cigarette cigarette = new Cigarette("Papierzosy", 14.88, 2137);
//		
//
//		given().
//	       contentType(MediaType.APPLICATION_JSON).
//	       body(cigarette).
//	    when().
//	    post("/cigarette/").then().assertThat().statusCode(is(201));
//	} 
}
