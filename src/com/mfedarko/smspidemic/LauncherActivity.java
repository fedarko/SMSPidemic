package com.mfedarko.smspidemic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is the activity that's run on application startup.
 */
public class LauncherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
	}
	
	public void goToStartGame(View v) {
		Intent i = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i);
	}
	
	public void goToGameStatus(View v) {
		Intent i = new Intent(getApplicationContext(), GameStatusActivity.class);
		startActivity(i);	
	}
	
	public void goToAboutScreen(View v) {
		Intent i = new Intent(getApplicationContext(), AboutActivity.class);
		startActivity(i);
	}
}
