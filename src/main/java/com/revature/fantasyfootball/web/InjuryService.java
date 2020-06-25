package com.revature.fantasyfootball.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.InjuriesDAO;
import com.revature.fantasyfootball.dao.InjuriesDAOImpl;
import com.revature.fantasyfootball.model.Injuries;
import com.revature.fantasyfootball.model.Player;

@Path("/injuries")
public class InjuryService {

	InjuriesDAO injuryDb = new InjuriesDAOImpl();
	
	@GET
	@Path("/ir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIR() {
		return Response.ok((ArrayList<Injuries>)injuryDb.getIRList()).build();
	}
	
	@POST
	@Path("/injuredplayer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getInjury(Player player) {
		return Response.ok(injuryDb.getPlayerHealth(player)).build();
	}
}
