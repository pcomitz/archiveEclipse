package com.s413.verysimpleintent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class VerySimpleIntentActivity extends Activity {

	private Button button; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_very_simple_intent);
		
		button = (Button)findViewById(R.id.button); 
		button.setOnClickListener(new IntentListener()); 
	}
	private class IntentListener implements OnClickListener
	{
		@Override
		public void onClick(View view) 
		{
			// Create the Intent
			Intent myIntent = new Intent(VerySimpleIntentActivity.this, 
					NewActivity.class); 
			startActivity(myIntent); 
		}
	}
} ///~
