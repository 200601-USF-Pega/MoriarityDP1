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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootball.dao.AdminDAO;
import com.revature.fantasyfootball.dao.AdminDAOImpl;
import com.revature.fantasyfootball.dao.InjuriesDAO;
import com.revature.fantasyfootball.dao.InjuriesDAOImpl;
import com.revature.fantasyfootball.model.Injuries;
import com.revature.fantasyfootball.model.NFLSchedule;

@Path("/admin")
public class AdminService {

	static Logger LOGGER = LogManager.getLogger(FantasyTeamService.class);
	AdminDAO adminDb = new AdminDAOImpl();
	InjuriesDAO irDb = new InjuriesDAOImpl();
	@POST
	@Path("/addir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToIR(Injuries injury) {
		if (adminDb.addToIR(injury)) {
			LOGGER.info("Successful add to IR");
			return Response.status(201).build();
			
		} else {
			LOGGER.error("ERROR: Player could not be added to IR");
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
	
	@POST
	@Path("/updatescores")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateScores(ArrayList<NFLSchedule> week) {
		for (NFLSchedule game: week) {
			adminDb.updateGame(game);
		}
		
		adminDb.updateWins();
		adminDb.updateLosses();
		adminDb.updateTies();
		adminDb.updateNextOpponent();
		return Response.status(201).build();
	}
	
	
}
