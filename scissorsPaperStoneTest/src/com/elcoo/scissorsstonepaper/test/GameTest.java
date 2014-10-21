package com.elcoo.scissorsstonepaper.test;

import android.test.AndroidTestCase;

import com.elcoo.scissorsstonepaper.Game;

public class GameTest extends AndroidTestCase {
	
	public GameTest(){
		
	}
	
	public void testPlaying(){
		Game game = new Game();
		game.setDevWeapon("stone");
		game.playTurn("scissors");
	}
	

}
