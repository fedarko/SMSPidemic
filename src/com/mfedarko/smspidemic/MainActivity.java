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

	private ArrayList<String> player_names = new ArrayList<String>();
	private ArrayList<String> player_phoneNumbers = new ArrayList<String>();
	
	private int PICK_CONTACT_REQUEST = 1;
	
	private TextView results;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		results = (TextView) findViewById(R.id.contactGetResults);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACT_REQUEST) {
			if (resultCode == RESULT_OK) {
				// Contact successfully picked!
				Uri contactUri = data.getData();
				// 1. Select Phone Number
				String[] projection = {Phone.NUMBER};

				results.setText("HAPPEN");
//				Cursor cursor = getContentResolver().query(
//					contactUri, projection, null, null, null
//				);
//				cursor.moveToFirst();
//
//				int col = cursor.getColumnIndex(Phone.NUMBER);
//				String phone_number = cursor.getString(col);
//				player_phoneNumbers.add(phone_number);
				
				// 2. Select Name
//				int nameCol = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//				String name = cursor.getString(nameCol);
//				player_names.add(name);
			}
		}
	}
	
	public void contact_lookup(View v) {
		Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
		startActivityForResult(i, PICK_CONTACT_REQUEST);
		if (!(player_phoneNumbers.isEmpty()))
			results.setText(player_phoneNumbers.get(0));
	}
}