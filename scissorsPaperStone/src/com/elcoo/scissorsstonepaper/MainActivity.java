package com.elcoo.scissorsstonepaper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	
	TextView h1;
	TextView h2ChooseWeapon;
	TextView console;
	Button btnScissors;
	Button btnStone;
	Button btnPaper;
	Button btnUserInfo;
	Context context;
	Game currentGame;
	
	static TextView userWeapon;
	static TextView winner;
	static TextView devWeapon;
	
	private String scissors;
	private String stone;
	private String paper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();
		currentGame = new Game();
		scissors = "scissors";		
		stone = "stone";
		paper = "paper";
		
		h1 = (TextView) findViewById(R.id.h1);
		h2ChooseWeapon = (TextView) findViewById(R.id.h2_choose_weapon);
		console = (TextView) findViewById(R.id.console_output);
		btnScissors = (Button) findViewById(R.id.btn_scissors);
		btnStone = (Button) findViewById(R.id.btn_stone);
		btnPaper = (Button) findViewById(R.id.btn_paper);
		btnUserInfo = (Button) findViewById(R.id.btn_user_info);
		
		userWeapon = (TextView) findViewById(R.id.results_u_weapon_value);
		winner = (TextView) findViewById(R.id.results_winner_value);
		devWeapon = (TextView) findViewById(R.id.results_dev_weapon_value);
		
		btnScissors.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {				
				currentGame.playTurn(scissors, console);
				setResultHeader(currentGame.getUserWeapon(), currentGame.getResult(), currentGame.getDevWeapon());
			}
		});
		
		btnStone.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {				
				currentGame.playTurn(stone, console);
				setResultHeader(currentGame.getUserWeapon(), currentGame.getResult(), currentGame.getDevWeapon());
			}
		});
		
		btnPaper.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {				
				currentGame.playTurn(paper, console);
				setResultHeader(currentGame.getUserWeapon(), currentGame.getResult(), currentGame.getDevWeapon());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static void setResultHeader(String uWeapon, String result, String dWeapon) {
		if ( uWeapon != null && result != null && dWeapon != null ) {
			userWeapon.setText(uWeapon);
			winner.setText(result);
			devWeapon.setText(dWeapon);
		}
		
		
	}
}
