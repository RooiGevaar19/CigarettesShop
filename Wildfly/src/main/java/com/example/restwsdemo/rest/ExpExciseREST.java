package com.example.restwsdemo.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Cigarette;
import com.example.restwsdemo.domain.Excise;
import com.example.restwsdemo.service.ExciseManager;

@Path("exp")
public class ExpExciseREST {
	@EJB
	ExciseManager em;
	
	@GET
	@Path("/{cigId}")
	public Response get(@PathParam("cigId") long id) {
		if (em.getExcise(id) == null) {
			em.addExcise(new Excise("E1", 0.5));
		}
		

		return Response.status(201).build();
	}
}
