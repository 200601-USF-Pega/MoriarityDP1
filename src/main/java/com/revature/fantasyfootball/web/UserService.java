package com.revature.fantasyfootball.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wildfly.plugin.server.User;

import com.revature.fantasyfootball.dao.UserDAO;
import com.revature.fantasyfootball.dao.UserDAOImpl;

@Path("/login")
public class UserService {

	UserDAO userDb = new UserDAOImpl();
	
	//check implementation
	@POST
	@Path("/home")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(User user) {
		return Response.ok(userDb.getUser(user.getUsername())).build();
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		if (userDb.addUser(user.getUsername(), user.getPassword())) {
			return Response.status(201).build();
		} else {
			return Response.status(401).build();
		}
	}
	
}
