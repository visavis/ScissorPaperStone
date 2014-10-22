package com.elcoo.scissorsstonepaper;

import java.util.Random;


public class Game {
	private String currentUserWeapon;
	private String currentDevWeapon = "stone";	
	private int currentWinner;
	private String result;
	
	public void playTurn( String weapon ){
		this.currentUserWeapon = weapon;
		this.currentWinner = findWinner(currentUserWeapon, currentDevWeapon);
		this.result = printResult(currentWinner);
		this.currentDevWeapon = newDevWeapon();
	}
	
	private int findWinner(String userWeapon, String devWeapon){
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
	
	private String printResult(int winner){
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
	
	private String newDevWeapon(){
		Random cGen = new Random();
		int weapon = cGen.nextInt(3) + 1;
		String dWeapon = "";
		switch(weapon){
		case 1:
			dWeapon = "scissors";
			break;
		case 2:
			dWeapon =  "stone";
			break;
		case 3:
			dWeapon = "paper";
			break;
		}
		return dWeapon;
	}
	
	public void setDevWeapon(String weapon){
		this.currentDevWeapon = weapon;
	}
	
	public String getDevWeapon(){
		return this.currentDevWeapon;
	}
	
	public String getUserWeapon(){
		return this.currentUserWeapon;
	}
	
	public String getResult(){
		return this.result;
	}
}
