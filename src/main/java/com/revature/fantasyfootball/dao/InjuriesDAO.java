package com.revature.fantasyfootball.dao;

import java.util.List;

import com.revature.fantasyfootball.model.Injuries;
import com.revature.fantasyfootball.model.Player;

public interface InjuriesDAO {

	public Injuries getPlayerHealth(Player player);
	public List<Injuries> getIRList();
}
