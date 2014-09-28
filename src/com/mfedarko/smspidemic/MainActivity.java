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

	private ArrayList<Player> players = new ArrayList<Player>();
	
	private int PICK_CONTACT_REQUEST = 1;
	
	private TextView results;
	
	// TODO make launchpad activity with options of
	// "start game" (MainActivity) + "game status" (GameStatusActivity) buttons
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		results = (TextView) findViewById(R.id.contactGetResults);
		// TODO add user as player: prompt user for his/her name and phone #
	}
	
	public void start_game(View v) {
		results.setText("Starting game!\n(nothing is happening tho)");
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACT_REQUEST) {
			if (resultCode == RESULT_OK) {
				// Contact successfully picked!
				Uri contactUri = data.getData();
				// 1. Select Phone Number
				String[] projection = {Phone.NUMBER};

				Cursor cursor = getContentResolver().query(
					contactUri, projection, null, null, null
				);
				
				cursor.moveToFirst();
//
				int col = cursor.getColumnIndex(Phone.NUMBER);
				String phone_number = cursor.getString(col);
				
				// 2. Select Name
//				int nameCol = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//				String name = cursor.getString(nameCol);
				
				Player p = new Player("Bob Example", phone_number);
				players.add(p);
			}
		}
	}
	
	public void contact_lookup(View v) {
		/** Doesn't actually work yet. So, TODO, do that if time allows, I guess. */
		Intent i = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
		i.setType(Phone.CONTENT_TYPE);
		startActivityForResult(i, PICK_CONTACT_REQUEST);
	}
}