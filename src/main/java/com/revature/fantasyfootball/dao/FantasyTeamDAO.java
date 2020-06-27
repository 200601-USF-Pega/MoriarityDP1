package com.revature.fantasyfootball.dao;

import java.util.ArrayList;

import com.revature.fantasyfootball.model.FantasyTeam;
import com.revature.fantasyfootball.model.User;

public interface FantasyTeamDAO {

	public FantasyTeam getFantasyTeam(String user);
	public ArrayList<FantasyTeam> getTeamsForUser(User user);
	public boolean makeNewFantasyTeam(FantasyTeam newTeam);
	public boolean dropFantasyTeam(FantasyTeam team);
	public boolean replaceQB(String user, String newQb);
	public boolean replaceRB1(String user, String newRb1);
	public boolean replaceRB2(String user, String newRb2);
	public boolean replaceWR1(String user, String newWr1);
	public boolean replaceWR2(String user, String newWr2);
	public boolean replaceTE(String user, String newTe);
	public boolean replaceFlex(String user, String newFlex);
	public boolean replaceDST(String user, String newDSt);
	public boolean replaceK(String user, String newK);
}
