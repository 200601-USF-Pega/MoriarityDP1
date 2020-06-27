package com.revature.fantasyfootball.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.FantasyTeamDAO;
import com.revature.fantasyfootball.dao.FantasyTeamDAOImpl;
import com.revature.fantasyfootball.model.FantasyTeam;
import com.revature.fantasyfootball.model.User;

@Path("/fantasyteam")
public class FantasyTeamService {

	FantasyTeamDAO ftDb = new FantasyTeamDAOImpl();
	
	@GET
	@Path("/team")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeam(User user) {
		return Response.ok(ftDb.getFantasyTeam(user.getUsername())).build();
	}
	
	@POST
	@Path("/myteams")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeams(User user) {
		return Response.ok(ftDb.getTeamsForUser(user)).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTeam(FantasyTeam newTeam) {
		ftDb.makeNewFantasyTeam(newTeam);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTeam(FantasyTeam team) {
		ftDb.dropFantasyTeam(team);
		return Response.ok().build();
	}
}
