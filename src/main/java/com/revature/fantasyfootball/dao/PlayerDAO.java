package com.revature.fantasyfootball.dao;

import com.revature.fantasyfootball.model.Player;

public interface PlayerDAO {

	public Player getPlayerByName(String playerName);
}
