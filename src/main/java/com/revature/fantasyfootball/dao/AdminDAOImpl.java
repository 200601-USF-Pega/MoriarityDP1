package com.revature.fantasyfootball.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootball.model.Injuries;
import com.revature.fantasyfootball.model.NFLSchedule;
import com.revature.fantasyfootball.services.DAOUtilities;

public class AdminDAOImpl implements AdminDAO{
	
	private static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement cstmt = null;
	
	@Override
	public boolean updateInjury(Injuries injury) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("update injuries set health_status=?, injury=?, week_to_return=? where name=?;");
			stmt.setString(1, String.valueOf(injury.getHealthStatus()));
			stmt.setString(2, injury.getInjury());
			stmt.setInt(3, injury.getWeekToReturn());
			stmt.setString(4, injury.getName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateInjury");
			return false;
		}
	}
	
	@Override
	public boolean addToIR(Injuries injury) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("INSERT INTO injuries VALUES (?, ?, ?, ?);");
			stmt.setString(1, injury.getName());
			stmt.setString(2, String.valueOf(injury.getHealthStatus()));
			stmt.setString(3, injury.getInjury());
			stmt.setInt(4, injury.getWeekToReturn());
			
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at addToIR");
			return false;
		}
		
	}

	@Override
	public boolean deleteFromIR(Injuries injury) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("DELETE FROM INJURIES WHERE name=?");
			stmt.setString(1, injury.getName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at deleteFromIR");
			return false;
		}
	}

	@Override
	public boolean updateGame(NFLSchedule game) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE NFL_SCHEDULE SET result=? WHERE team=? AND week=?;");
			stmt.setString(1, game.getResult());
			stmt.setString(2, game.getTeam());
			stmt.setInt(3, game.getWeek());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateGame");
			return false;
		}		
	}

	@Override
	public boolean updateWins() {
		try {
			connection= DAOUtilities.getConnection();
			cstmt = connection.prepareCall("call w_update();");
			cstmt.execute();
			if (cstmt.SUCCESS_NO_INFO != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateWins");
			return false;
		}
		
	}
	
	@Override
	public boolean updateLosses() {
		try {
			connection = DAOUtilities.getConnection();
			cstmt = connection.prepareCall("call l_update();");
			cstmt.execute();
			if (cstmt.SUCCESS_NO_INFO != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateLosses");
			return false;
		}
	}

	@Override
	public boolean updateTies() {
		try {
			connection = DAOUtilities.getConnection();
			cstmt = connection.prepareCall("call t_update();");
			cstmt.execute();
			if (cstmt.SUCCESS_NO_INFO != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateTies");
			return false;
		}
	}

	@Override
	public boolean updateNextOpponent() {
		try {
			connection = DAOUtilities.getConnection();
			cstmt = connection.prepareCall("call next_opponent();");
			cstmt.execute();
			if (cstmt.SUCCESS_NO_INFO != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateNextOpponent");
			return false;
		}
	}
}
