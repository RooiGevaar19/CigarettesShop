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

import com.example.restwsdemo.domain.Excise;
import com.example.restwsdemo.service.ExciseManager;

@Path("excise")
@Stateless
public class ExciseRESTService {

	@Inject
	private ExciseManager pm;

	@GET
	@Path("/{cigId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excise getExcise(@PathParam("cigId") Integer id) {
		Excise p = pm.getExcise(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excise> getExcises() {
		return pm.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addExcise(Excise cig) {
		pm.addExcise(cig);

		return Response.status(201).entity("Excise").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	@Path("/{cigId}")
	public Response removeExciseByID(@PathParam("cigId") int id) {
		pm.deleteExcise(id);
		return Response.status(200).build();
	}

}
