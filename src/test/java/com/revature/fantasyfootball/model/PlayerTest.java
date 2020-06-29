package com.revature.fantasyfootball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerTest {

		Player player = new Player("Colin Kaepernick", "QB", "San Francisco 49ers", 29.56, 'H', true, 27.43);
	
	@Test
	void nameTest() {
		assertEquals("Colin Kaepernick", player.getName());
	}
	
	@Test
	void positionTest() {
		assertEquals("QB", player.getPosition());
	}
	
	@Test
	void teamTest() {
		assertEquals("San Francisco 49ers", player.getTeam());
	}
	
	@Test
	void avgFantasyPtsTest() {
		assertEquals(29.56, player.getAvgFantasyPts());
	}
	
	@Test
	void healthStatusTest() {
		assertEquals('H', player.getHealthStatus());
	}
	
	@Test 
	void startingStatusTest() {
		assertTrue(player.isStartingStatus());
	}
	
	@Test
	void predPtsTest() {
		assertEquals(27.43, player.getPredictedPts());
	}

}
