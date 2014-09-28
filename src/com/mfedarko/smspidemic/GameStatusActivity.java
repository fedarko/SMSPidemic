package com.mfedarko.smspidemic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameStatusActivity extends Activity {

	private TextView gameStatus;
	//work on helper methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_game_status);
		gameStatus = (TextView) findViewById(R.id.StatusInfo);
		Game g = MainActivity.game1(); 
		String s="";
		
		for(int i=0;i<MainActivity.players.size();i++){
			String text="";
			if(MainActivity.players.get(i).isAlive())
				text="Alive";
			else
				text="Dead";
			
			s+=MainActivity.players.get(i)+": "+text+"\n\n";
		}
		
		gameStatus.setText(s);
	}

}
