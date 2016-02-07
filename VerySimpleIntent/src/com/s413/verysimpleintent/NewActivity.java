package com.s413.verysimpleintent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class NewActivity extends Activity 
{

	private Button b1; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		
		b1 = (Button)findViewById(R.id.b1); 
		b1.setOnClickListener(new ReturnListener()); 
	}
	
	private class ReturnListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			Intent retIntent = new Intent(NewActivity.this, 
					VerySimpleIntentActivity.class); 
			startActivity(retIntent);
		}
	}	
} ///~
