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

	//@GET
	//@Produces(MediaType.APPLICATION_JSON)
	//public List<Cigarette> getCigarettes() {
	//	return pm.getAllCigarettes();
	//}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCigarette(Cigarette cig) {
		pm.addCigarette(cig);

		return Response.status(201).entity("Cigarette").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	@Path("/{cigId}")
	public Response removeCigaretteByID(@PathParam("cigId") int id) {
		pm.deleteCigarette(id);
		return Response.status(200).build();
	}

}
