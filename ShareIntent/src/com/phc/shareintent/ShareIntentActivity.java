package com.phc.shareintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

/* 
 * A simple example of sharing an Intent
 */

public class ShareIntentActivity extends Activity {

	private ImageButton imageButton; 
	private EditText message; 
	private EditText phone; 
	private static final String TAG = "IS413"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_intent);
		
		imageButton = (ImageButton)findViewById(R.id.imageButton1); 
		message = (EditText)findViewById(R.id.message); 
		phone = (EditText)findViewById(R.id.phone); 
		
		imageButton.setOnClickListener(new Listener());
		
	}

	protected class Listener implements OnClickListener 
	{

		@Override
		public void onClick(View v) {
			// create an Intent 
			Intent intent = new Intent(Intent.ACTION_VIEW); 
			intent.setData(Uri.fromParts("sms", phone.getText().toString(), null)); 
			intent.putExtra("sms_body", message.getText().toString()); 
			
			//start  the activity 
			try { 
				//use a chooser
			startActivity(Intent.createChooser(intent,
					"Please choose a messaging app"));
			} catch(Exception ex)
			{
				Log.d(TAG, "Can't send ,message", ex); 
			}
			
			
		}
		
	}
	
}
