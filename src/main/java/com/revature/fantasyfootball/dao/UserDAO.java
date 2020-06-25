package com.revature.fantasyfootball.dao;

import com.revature.fantasyfootball.model.User;

public interface UserDAO {

	public User getUser(String username);
	public boolean addUser(String username, String password);
	public boolean deleteUser(User user); 
}
