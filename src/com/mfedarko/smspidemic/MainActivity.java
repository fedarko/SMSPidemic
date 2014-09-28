package com.mfedarko.smspidemic;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static ArrayList<Player> players = new ArrayList<Player>();
	private String playerNames="";
	private int PICK_CONTACT_REQUEST = 1;
	
	private TextView results;
	private long startTime;
	
	{
		startTime=System.currentTimeMillis();
		
	}
	// TODO make launchpad activity with options of
	// "start game" (MainActivity) + "game status" (GameStatusActivity) buttons
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		results = (TextView) findViewById(R.id.contactGetResults);
		// TODO add user as player: prompt user for his/her name and phone #
	}
	
	//starts the game. All players are assigned roles
	public void start_game(View v) {
		
		if(players.size()<10){
			System.out.println("You must have 10 or more people to begin.");
			return;
		}
		String text="Roles have been assigned. They are Visible for demo purposes:\n";
		results.setText(text);
		//remove player button
		//Should there be a new activity from here?
		Game g = new Game(players);
		for(Player p: players){
			results.setText(text+=p+"\n");
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACT_REQUEST) {
			if (resultCode == RESULT_OK) {
				// Contact successfully picked!
				Uri contactUri = data.getData();
				// 1. Select Phone Number
				String[] projection = {Phone.NUMBER};

				String[] p2={Phone.DISPLAY_NAME};
				
				Cursor cursor = getContentResolver().query(
					contactUri, projection, null, null, null
				);
				
				cursor.moveToFirst();
//
				int col = cursor.getColumnIndex(Phone.NUMBER);
				
				String phone_number = cursor.getString(col);
				
				for(int i=0;i<players.size();i++){
					if(players.get(i).getPhone().equals(phone_number)){
						System.out.println("YOU CANT DO THAT STUPID");
						return;
					}
				}
				/**------------**/
				cursor = getContentResolver().query(
						contactUri, p2, null, null, null
					);
					
					cursor.moveToFirst();
	
					int col2 = cursor.getColumnIndex(Phone.DISPLAY_NAME);
					
					String name = cursor.getString(col2);
				
				// 2. Select Name
//				int nameCol = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//				String name = cursor.getString(nameCol);
				
				Player p = new Player(name, phone_number);
				players.add(p);
				playerNames+=p+"\n";
				results.setText(playerNames);
			//	System.out.println(p.getName()+":DELETE PHONE LATER:::"+p.getPhone());
			}
		}
		
	}
	
	public void contact_lookup(View v) {
		/** Doesn't actually work yet. So, TODO, do that if time allows, I guess. */
		Intent i = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
		i.setType(Phone.CONTENT_TYPE);
		startActivityForResult(i, PICK_CONTACT_REQUEST);		
		
	}
	
	//test	
	public static Game game1(){

		ArrayList<Player> p = new ArrayList<Player>();
		for(int i=0;i<100;i++)
			p.add(new Player("HUMAN"+i+": ",i+""));	

		Game g=new Game(p);
		return g;
	}
}
