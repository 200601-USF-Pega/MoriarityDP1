package com.revature.fantasyfootball.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.fantasyfootball.dao.NFLScheduleDAO;
import com.revature.fantasyfootball.dao.NFLScheduleDAOImpl;
import com.revature.fantasyfootball.model.NFLSchedule;

@Path("/")
public class NFLScheduleService {
	
	NFLScheduleDAO schedDb = new NFLScheduleDAOImpl();
	
	@POST
	@Path("/week")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getWeek(NFLSchedule week) {
		return Response.ok((ArrayList<NFLSchedule>) schedDb.getWeek(week.getWeek())).build();
	}
}
