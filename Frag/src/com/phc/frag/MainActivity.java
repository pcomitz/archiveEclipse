package com.phc.frag;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;


public class MainActivity extends Activity {
	
	protected static final String TAG = "IS413 Frag"; 
	private RadioButton celsiusRadio; 
	private RadioButton fahrenheitRadio; 
	private TempListener tempListener; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get the button id
		celsiusRadio = (RadioButton)findViewById(R.id.celRadio); 
		fahrenheitRadio = (RadioButton)findViewById(R.id.fahRadio); 
		tempListener = new TempListener(this); 
		
		celsiusRadio.setOnClickListener(tempListener);
		fahrenheitRadio.setOnClickListener(tempListener);
		
		Log.d(TAG, "onCreate before commit"); 
		}
	} ///~
	
	
