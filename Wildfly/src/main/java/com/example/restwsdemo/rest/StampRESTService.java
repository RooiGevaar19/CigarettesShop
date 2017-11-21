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

import com.example.restwsdemo.domain.Stamp;
import com.example.restwsdemo.service.StampManager;

@Path("stamp")
@Stateless
public class StampRESTService {

	@Inject
	private StampManager pm;

	@GET
	@Path("/{cigId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Stamp getStamp(@PathParam("cigId") Integer id) {
		Stamp p = pm.getStamp(id);
		return p;
	}

	//@GET
	//@Produces(MediaType.APPLICATION_JSON)
	//public List<Cigarette> getCigarettes() {
	//	return pm.getAllCigarettes();
	//}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStamp(Stamp cig) {
		pm.addStamp(cig);

		return Response.status(201).entity("Stamp").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	@Path("/{cigId}")
	public Response removeStampByID(@PathParam("cigId") int id) {
		pm.deleteStamp(id);
		return Response.status(200).build();
	}

}
