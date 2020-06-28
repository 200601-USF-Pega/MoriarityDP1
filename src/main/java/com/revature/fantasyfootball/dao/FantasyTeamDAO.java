package com.revature.fantasyfootball.dao;

import java.util.ArrayList;

import com.revature.fantasyfootball.model.FantasyTeam;
import com.revature.fantasyfootball.model.User;

public interface FantasyTeamDAO {

	public FantasyTeam getFantasyTeam(String user, String teamName);
	public ArrayList<FantasyTeam> getTeamsForUser(User user);
	public boolean makeNewFantasyTeam(FantasyTeam newTeam);
	public boolean dropFantasyTeam(FantasyTeam team);
	public boolean replaceQB(String user, String teamName, String newQb);
	public boolean replaceRB1(String user, String teamName, String newRb1);
	public boolean replaceRB2(String user, String teamName, String newRb2);
	public boolean replaceWR1(String user, String teamName, String newWr1);
	public boolean replaceWR2(String user, String teamName, String newWr2);
	public boolean replaceTE(String user, String teamName, String newTe);
	public boolean replaceFlex(String user, String teamName, String newFlex);
	public boolean replaceDST(String user, String teamName, String newDSt);
	public boolean replaceK(String user, String teamName, String newK);
}
