package com.revature.fantasyfootball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void getUsernameTest() {
		String username = "user1";
		User user = new User();
		user.setUsername(username);
		assertEquals(username, user.getUsername());
	}
	
	@Test
	void getPasswordTest() {
		String password = "password";
		User user = new User();
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}

	@Test
	void constructorTest() {
		User user = new User("user1", "password");
		assertEquals("user1", user.getUsername());
		assertEquals("password", user.getPassword());
	}
}
