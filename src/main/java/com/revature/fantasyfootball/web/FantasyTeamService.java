package com.revature.fantasyfootball.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	
	@POST
	@Path("/team")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeam(FantasyTeam team) {
		return Response.ok(ftDb.getFantasyTeam(team.getUser(), team.getTeamName())).build();
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
	
	@POST
	@Path("/replaceQB")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceQB(FantasyTeam team) {
		if (ftDb.replaceQB(team.getUser(), team.getTeamName(), team.getQb())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceRB1")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceRB1(FantasyTeam team) {
		if (ftDb.replaceRB1(team.getUser(), team.getTeamName(), team.getRb1())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceRB2")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceRB2(FantasyTeam team) {
		if (ftDb.replaceRB2(team.getUser(), team.getTeamName(), team.getRb2())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceWR1")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceWR1(FantasyTeam team) {
		if (ftDb.replaceWR1(team.getUser(), team.getTeamName(), team.getWr1())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceWR2")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceWR2(FantasyTeam team) {
		if (ftDb.replaceWR2(team.getUser(), team.getTeamName(), team.getWr2())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceTE")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceTE(FantasyTeam team) {
		if (ftDb.replaceTE(team.getUser(), team.getTeamName(), team.getTe())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceFlex")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceFlex(FantasyTeam team) {
		if (ftDb.replaceFlex(team.getUser(), team.getTeamName(), team.getFlex())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceDST")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceDST(FantasyTeam team) {
		if (ftDb.replaceDST(team.getUser(), team.getTeamName(), team.getDSt())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
	@POST
	@Path("/replaceK")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceK(FantasyTeam team) {
		if (ftDb.replaceK(team.getUser(), team.getTeamName(), team.getK())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
}
