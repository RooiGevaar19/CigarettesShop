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

import com.example.restwsdemo.domain.Owner;
import com.example.restwsdemo.service.OwnerManager;

@Path("owner")
@Stateless
public class OwnerRESTService {

	@Inject
	private OwnerManager pm;

	@GET
	@Path("/{cigId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getOwner(@PathParam("cigId") Integer id) {
		Owner p = pm.getOwner(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner> getOwners() {
		return pm.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOwner(Owner cig) {
		pm.addOwner(cig);

		return Response.status(201).entity("Owner").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	@Path("/{cigId}")
	public Response removeOwnerByID(@PathParam("cigId") int id) {
		pm.deleteOwner(id);
		return Response.status(200).build();
	}

}
