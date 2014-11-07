package com.elcoo.scissorsstonepaper;

import java.util.Random;

import android.widget.TextView;

public class Game {
	private String currentUserWeapon;
	private String previousDevWeapon;
	private String currentDevWeapon = "stone";
	private String nextDevWeapon;
	private int currentWinner;
	private String result;

	private String[] userPicks = new String[30];
	private String[] devPicks = new String[30];
	private int turn;	
// pass desired text field into playTurn void, so it can display some values back in MainActivity
	public void playTurn( String weapon, TextView...params) {
		this.currentUserWeapon = weapon;
		if (this.nextDevWeapon != null) {
			this.currentDevWeapon = this.nextDevWeapon;
		}
		this.currentWinner = findWinner(currentUserWeapon, currentDevWeapon);
		this.result = printResult(currentWinner);
		this.nextDevWeapon = newDevWeapon();

		userPicks[turn] = weapon;
		devPicks[turn] = currentDevWeapon;
		String cons = weapon +" " + currentDevWeapon + " " + new Integer(turn + 1).toString();
		if ( params.length > 0) {
			params[0].setText(cons);
		}
		if (turn < 29) {
		 addTurn();
		} else { 
			turn = 0;
		}
	}

	private int findWinner(String userWeapon, String devWeapon) {
		int result = 0;
		String uWeapon = userWeapon;
		String cWeapon = devWeapon;
		if (uWeapon == cWeapon) {
			result = 0;
		} else if (uWeapon == "scissors") {
			if (cWeapon == "stone") {
				result = -1;
			} else {
				result = 1;
			}
		} else if (uWeapon == "stone") {
			if (cWeapon == "scissors") {
				result = 1;
			} else {
				result = -1;
			}
		} else if (uWeapon == "paper") {
			if (cWeapon == "scissors") {
				result = -1;
			} else {
				result = 1;
			}
		}
		return result;
	}

	public String printResult(int winner) {
		int result = winner;
		String output;
		if (result == 0) {
			output = "Pat";
		} else if (result == -1) {
			output = "you lose";
		} else {
			output = "you win";
		}
		return output;
	}

	public String newDevWeapon() {
		if (turn > 0) {
			if (currentUserWeapon == "scissors") {
				if (getUserPick(turn - 1) == "scissors") {
					return "scissors";
				} else if (getUserPick(turn - 1) == "stone") {
					return "stone";
				} else {
					return "paper";
				}
			} else {
				return randomWeapon();
			}
		} else {
			if (currentUserWeapon == "scissors") {
				return "stone";
			} else if (currentUserWeapon == "stone") {
				return "paper";
			} else if (currentUserWeapon == "paper") {
				return "scissors";
			} else {
				return randomWeapon();
			}
		}
	}

	private String randomWeapon() {
		Random cGen = new Random();
		int weapon = cGen.nextInt(3) + 1;
		String dWeapon = "";

		switch (weapon) {
		case 1:
			dWeapon = "scissors";
			break;
		case 2:
			dWeapon = "stone";
			break;
		case 3:
			dWeapon = "paper";
			break;
		}
		return dWeapon;
	}

	public void setDevWeapon(String weapon) {
		this.currentDevWeapon = weapon;
	}

	public String getDevWeapon() {
		return this.currentDevWeapon;
	}

	public String getDevPick(int turn) {
		return this.devPicks[turn];
	}

	public void setUserWeapon(String weapon) {
		this.currentUserWeapon = weapon;
	}

	public String getUserWeapon() {
		return this.currentUserWeapon;
	}

	public String getUserPick(int turn) {
		return this.userPicks[turn];
	}

	public String getResult() {
		return this.result;
	}

	public void addTurn() {
		this.turn += 1;
	}

	public int getTurnNo() {
		return this.turn;
	}
}
