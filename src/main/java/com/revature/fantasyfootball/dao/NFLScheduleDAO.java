package com.revature.fantasyfootball.dao;

import java.util.List;

import com.revature.fantasyfootball.model.NFLSchedule;
import com.revature.fantasyfootball.model.NFLTeam;

public interface NFLScheduleDAO {

	public List<NFLSchedule> getWeek(int weekNumber);
	public NFLTeam getNextOpponent(int weekNumber, NFLTeam team);
	public List<NFLSchedule> getFullSchedule();
	public List<NFLSchedule> getRemainingSchedule(int currentWeek);
	public List<NFLSchedule> getScheduleForTeam(NFLTeam team);
}
