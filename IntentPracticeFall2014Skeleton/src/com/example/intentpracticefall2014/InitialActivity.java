package com.example.intentpracticefall2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InitialActivity extends Activity {
	
	private Button button; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial);
		
		button =(Button)findViewById(R.id.button); 
		
		button.setOnClickListener(new MyListener()); 
	}
	
	private class MyListener implements OnClickListener {
		public void onClick(View v) {
			Intent next = new Intent(InitialActivity.this, NextActivity.class); 
			startActivity(next); 
		}
	}

} ///~
