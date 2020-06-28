package com.revature.fantasyfootball.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootball.model.FantasyTeam;
import com.revature.fantasyfootball.model.User;
import com.revature.fantasyfootball.services.DAOUtilities;

public class FantasyTeamDAOImpl implements FantasyTeamDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public FantasyTeam getFantasyTeam(String user, String teamName) {
		FantasyTeam team = new FantasyTeam();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM FANTASY_TEAMS WHERE username=? AND team_name=?");
			stmt.setString(1, user);
			stmt.setString(2, teamName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				team.setUser(rs.getString("username"));
				team.setTeamName(rs.getString("team_name"));
				team.setQb(rs.getString("qb"));
				team.setRb1(rs.getString("rb1"));
				team.setRb2(rs.getString("rb2"));
				team.setWr1(rs.getString("wr1"));
				team.setWr2(rs.getString("wr2"));
				team.setTe(rs.getString("te"));
				team.setFlex(rs.getString("flex"));
				team.setDSt(rs.getString("d_st"));
				team.setK(rs.getString("k"));
			}
		} catch (SQLException e) {
			LOGGER.debug("at getFantasyTeam");
		}
		return team;
	}
	
	@Override
	public ArrayList<FantasyTeam> getTeamsForUser(User user) {
		ArrayList<FantasyTeam> teams = new ArrayList<>();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM FANTASY_TEAMS WHERE username=?");
			stmt.setString(1, user.getUsername());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FantasyTeam team = new FantasyTeam();
				team.setUser(rs.getString("username"));
				team.setTeamName(rs.getString("team_name"));
				team.setQb(rs.getString("qb"));
				team.setRb1(rs.getString("rb1"));
				team.setRb2(rs.getString("rb2"));
				team.setWr1(rs.getString("wr1"));
				team.setWr2(rs.getString("wr2"));
				team.setTe(rs.getString("te"));
				team.setFlex(rs.getString("flex"));
				team.setDSt(rs.getString("d_st"));
				team.setK(rs.getString("k"));
				
				teams.add(team);
			}
			
		} catch (SQLException e) {
			LOGGER.debug("at getTeamsForUser");
		}
		
		return teams;
	}

	@Override
	public boolean makeNewFantasyTeam(FantasyTeam newTeam) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("INSERT INTO FANTASY_TEAMS VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, newTeam.getUser());
			stmt.setString(2, newTeam.getTeamName());
			stmt.setString(3, newTeam.getQb());
			stmt.setString(4, newTeam.getRb1());
			stmt.setString(5, newTeam.getRb2());
			stmt.setString(6, newTeam.getWr1());
			stmt.setString(7, newTeam.getWr2());
			stmt.setString(8, newTeam.getTe());
			stmt.setString(9, newTeam.getFlex());
			stmt.setString(10, newTeam.getDSt());
			stmt.setString(11, newTeam.getK());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at makeNewFantasyTeam");
			return false;
		}
		
	}

	@Override
	public boolean dropFantasyTeam(FantasyTeam team) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("DELETE FROM FANTASY_TEAMS WHERE username=? AND team_name=?");
			stmt.setString(1, team.getUser());
			stmt.setString(2, team.getTeamName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at dropFantasyTeam");
			return false;
		}
	}

	@Override
	public boolean replaceQB(String user, String teamName, String newQb) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET qb=? WHERE username=? AND team_name=?");
			stmt.setString(1, newQb);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replaceQB");
			return false;
		}
	}

	@Override
	public boolean replaceRB1(String user, String teamName, String newRb1) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET rb1=? WHERE username=? AND team_name=?");
			stmt.setString(1,  newRb1);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replaceRB1");
			return false;
		}
	}

	@Override
	public boolean replaceRB2(String user, String teamName, String newRb2) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET rb2=? WHERE username=? AND team_name=?");
			stmt.setString(1,  newRb2);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replace RB2");
			return false;
		}
	}

	@Override
	public boolean replaceWR1(String user, String teamName, String newWr1) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET wr1=? WHERE username=? AND team_name=?");
			stmt.setString(1,  newWr1);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replace WR1");
			return false;
		}
	}

	@Override
	public boolean replaceWR2(String user, String teamName, String newWr2) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET wr2=? WHERE username=? AND team_name=?;");
			stmt.setString(1,  newWr2);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replace WR2");
			return false;
		}
	}

	@Override
	public boolean replaceTE(String user, String teamName, String newTe) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET te=? WHERE username=? AND team_name=?;");
			stmt.setString(1, newTe);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replaceTE");
			return false;
		}
	}

	@Override
	public boolean replaceFlex(String user, String teamName, String newFlex) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET flex=? WHERE username=? AND team_name=?;");
			stmt.setString(1,  newFlex);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replaceFlex");
			return false;
		}
	}

	@Override
	public boolean replaceDST(String user, String teamName, String newDSt) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET d_st=? WHERE username=? AND team_name=?;");
			stmt.setString(1,  newDSt);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at replaceDST");
			return false;
		}
	}

	@Override
	public boolean replaceK(String user, String teamName, String newK) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE FANTASY_TEAMS SET k=? WHERE username=? AND team_name=?");
			stmt.setString(1,  newK);
			stmt.setString(2, user);
			stmt.setString(3, teamName);
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("replaceK");
			return false;
		}
	}
}
