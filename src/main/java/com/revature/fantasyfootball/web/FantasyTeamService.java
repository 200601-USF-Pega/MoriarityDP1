package com.revature.fantasyfootball.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.FantasyTeamDAO;
import com.revature.fantasyfootball.dao.FantasyTeamDAOImpl;

@Path("/fantasyteam")
public class FantasyTeamService {

	FantasyTeamDAO ftDb = new FantasyTeamDAOImpl();
	
	@GET
	@Path("/team")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeam(String user) {
		return Response.ok(ftDb.getFantasyTeam(user)).build();
	}
}
