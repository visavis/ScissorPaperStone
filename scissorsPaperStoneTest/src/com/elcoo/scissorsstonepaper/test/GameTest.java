package com.elcoo.scissorsstonepaper.test;

import android.test.AndroidTestCase;

import com.elcoo.scissorsstonepaper.Game;

public class GameTest extends AndroidTestCase {
	
	public GameTest(){
		
	}
	
	public void testScissorsToStone(){
		Game game = new Game();
		game.setDevWeapon("stone");
		game.playTurn("scissors");
		assertEquals("you lose", game.getResult());
	}
	
	public void testPaperToStone(){
		Game game = new Game();
		game.setDevWeapon("stone");
		game.playTurn("paper");
		assertEquals("you win", game.getResult());
	}
	
	public void testStoneToStone(){
		Game game = new Game();
		game.setDevWeapon("stone");
		game.playTurn("stone");
		assertEquals("Pat", game.getResult());
	}
	
	public void testScissorsToScissors(){
		Game game = new Game();
		game.setDevWeapon("scissors");
		game.playTurn("scissors");
		assertEquals("Pat", game.getResult());
	}
	
	public void testPaperToScissors(){
		Game game = new Game();
		game.setDevWeapon("scissors");
		game.playTurn("paper");
		assertEquals("you lose", game.getResult());
	}
	
	public void testStoneToScissors(){
		Game game = new Game();
		game.setDevWeapon("scissors");
		game.playTurn("stone");
		assertEquals("you win", game.getResult());
	}
	
	public void testScissorsToPaper(){
		Game game = new Game();
		game.setDevWeapon("paper");
		game.playTurn("scissors");
		assertEquals("you win", game.getResult());
	}
	
	public void testPaperToPaper(){
		Game game = new Game();
		game.setDevWeapon("paper");
		game.playTurn("paper");
		assertEquals("Pat", game.getResult());
	}
	
	public void testStoneToPaper(){
		Game game = new Game();
		game.setDevWeapon("paper");
		game.playTurn("stone");
		assertEquals("you lose", game.getResult());
	}	

}
