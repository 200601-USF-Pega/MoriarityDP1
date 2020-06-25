package com.revature.fantasyfootball.dao;

import java.util.List;

import com.revature.fantasyfootball.model.Injuries;
import com.revature.fantasyfootball.model.NFLSchedule;
import com.revature.fantasyfootball.model.NFLTeam;
import com.revature.fantasyfootball.model.Player;

public interface AdminDAO {

	public boolean updateInjury(Injuries injury);
	public boolean addToIR(Injuries injury);
	public boolean deleteFromIR(Injuries injury);
	public boolean updateGame(NFLSchedule game); 
	public boolean updateWins();
	public boolean updateLosses();
	public boolean updateTies();
	public boolean updateNextOpponent();
}
