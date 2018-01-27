package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Cigarette;
import com.example.restwsdemo.service.CigaretteManager;

@Path("cigarette")
@Stateless
public class CigaretteRESTService {

	@Inject
	private CigaretteManager pm;

	@GET
	@Path("/{cigId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cigarette getCigarette(@PathParam("cigId") Integer id) {
		Cigarette p = pm.getCigarette(id);
		return p;
	}
	
	@GET
	@Path("/find/{cigId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cigarette> findCigarette(@PathParam("cigId") Integer id) {
		List<Cigarette> p = pm.findCigarette(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cigarette> getCigarettes() {
		return pm.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCigarette(Cigarette cig) {
		pm.addCigarette(cig);

		return Response.status(201).entity("Cigarette").build();
	}
	
	@GET
	@Path("/add")
	public Response addCigarettes(){
		pm.addCigarette(new Cigarette("Papierzosy", 21.37, 2137));
		pm.addCigarette(new Cigarette("Kiepy", 14.88, 1488));
		pm.addCigarette(new Cigarette("Skrety", 9.11, 199));
		pm.addCigarette(new Cigarette("Marlboro", 16.50, 3456));
		return Response.status(201).entity("Cigarette").build(); 
	}

	@GET
	@Path("/testcig")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		//pm.addCigarette(new Cigarette("Marlboro", 16.50, 2137));
		return "REST API /person is running today! XD";
	}

	@DELETE
	@Path("/{cigId}")
	public Response removeCigaretteByID(@PathParam("cigId") int id) {
		pm.deleteCigarette(id);
		return Response.status(200).build();
	}

}
