package com.revature.fantasyfootball.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.revature.fantasyfootball.dao.PlayerDAO;
import com.revature.fantasyfootball.dao.PlayerDAOImpl;
import com.revature.fantasyfootball.model.Player;

@Path("/players")
public class PlayerService {

	PlayerDAO playerDb = new PlayerDAOImpl();
	
	
	@POST
	@Path("/player")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(Player player) {
		return playerDb.getPlayerByName(player.getName());
	}
}
