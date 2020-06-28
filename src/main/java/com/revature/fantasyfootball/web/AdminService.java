package com.revature.fantasyfootball.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.AdminDAO;
import com.revature.fantasyfootball.dao.AdminDAOImpl;
import com.revature.fantasyfootball.dao.InjuriesDAO;
import com.revature.fantasyfootball.dao.InjuriesDAOImpl;
import com.revature.fantasyfootball.model.Injuries;

@Path("/admin")
public class AdminService {

	AdminDAO adminDb = new AdminDAOImpl();
	InjuriesDAO irDb = new InjuriesDAOImpl();
	@POST
	@Path("/addir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToIR(Injuries injury) {
		if (adminDb.addToIR(injury)) {
			return Response.status(201).build();
		} else {
			return Response.status(500).build();
		}
		
		
	}
	
	@POST
	@Path("/updateir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateIR(Injuries injury) {
		adminDb.updateInjury(injury);
		return Response.status(201).build();
	}
	
	@GET
	@Path("/ir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIR() {
		return Response.ok((ArrayList<Injuries>) irDb.getIRList()).build();
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFromIR(Injuries injury) {
		adminDb.deleteFromIR(injury);
		return Response.status(201).build();
	}
}
