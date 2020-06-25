package com.revature.fantasyfootball.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.NFLTeamDAO;
import com.revature.fantasyfootball.dao.NFLTeamDAOImpl;
import com.revature.fantasyfootball.model.NFLTeam;

@Path("/matchups")
public class NFLTeamService {

	NFLTeamDAO teamDb = new NFLTeamDAOImpl();
	
	@POST
	@Path("/matchup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMatchup(NFLTeam team) {
		return Response.ok(teamDb.getNFLTeam(team.getTeam())).build();
	}
}
