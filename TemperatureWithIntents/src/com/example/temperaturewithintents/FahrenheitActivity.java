package com.example.temperaturewithintents;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import com.is413.temperature.*;

public class FahrenheitActivity extends Activity {
	
	private EditText editText;
	private Button buttonSubmit;
	private Button buttonToCelsius; 
	private TextView tvConverted;
	private Fahrenheit fahrenheit; 
	
	private static final String TAG = "IS413 Fahrenheit";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fahrenheit);
		
		//get the view ids
		editText =(EditText)findViewById(R.id.editText);
		buttonSubmit =(Button)findViewById(R.id.buttonSubmit); 
		tvConverted = (TextView)findViewById(R.id.tvConverted); 
		buttonToCelsius = (Button)findViewById(R.id.buttonToCelsius); 
		
		buttonSubmit.setOnClickListener(new ButtonListener()); 
		buttonToCelsius.setOnClickListener(new CelsiusListener());
	
		Log.i(TAG, "The activity has been created.");
	}
	
	/*
	 * Convert from f to C
	 */
	private class ButtonListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			String string; 
			DecimalFormat df = new DecimalFormat("####.##"); 
			
			// get the entered temperature 
			// TODO - is it a number ?
			string = editText.getText().toString(); 
			fahrenheit = new Fahrenheit(string); 
			tvConverted.setText("Temperature in Celsius: "+
								(df.format(new Float(fahrenheit.convert()))));
		}
	}//ButtonListener
	
	
	/*
	 * Use an an Intent to switch to the Celsius Activity
	 */
	private class CelsiusListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(FahrenheitActivity.this, 
					CelsiusActivity.class); 
			startActivity(intent); 
		}
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "The activity is visible and about to be started.");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "The activity is visible and about to be restarted.");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "The activity is and has focus (it is now \"resumed\")");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG,
				"Another activity is taking focus (this activity is about to be \"paused\")");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "The activity is no longer visible (it is now \"stopped\")");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "The activity is about to be destroyed.");
	}	
	
} ///~
