package com.example.restservicedemo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Cigarette;

@Path("cigarettes")
public class CigaretteManager {
	
	private Map<Long, Cigarette> storage = new HashMap<Long, Cigarette>();

	public CigaretteManager(){
		storage.put(1L, new Cigarette(1, "Marlboro", 16.00, 2137));
		storage.put(2L, new Cigarette(2, "Lucky Strike", 15.50, 1540));
		storage.put(3L, new Cigarette(3, "LM", 14.70, 1488));
		storage.put(4L, new Cigarette(4, "West", 14.20, 2137));
		storage.put(5L, new Cigarette(5, "Chesterfield", 13.20, 2137));
		storage.put(6L, new Cigarette(6, "Route 66", 12.50, 997));
		storage.put(7L, new Cigarette(7, "Rothmans", 11.99, 2137));
	}
	
	@GET
	@Path("/{cigId}")
	@Produces("application/json")
	public Cigarette getCigarette(@PathParam("cigId") Long id){
		Cigarette p = storage.get(id);
		if (p == null) return new Cigarette();
		return p;
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public Collection<Cigarette> getAllCigarettes(@PathParam("cigId") Long id){
		return storage.values();
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Cigarette cig) {
		System.out.println(cig.getName());
		storage.put((long) cig.getID(), cig);
		return Response.status(Response.Status.OK).build();
	}

}
