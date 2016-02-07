package com.example.temperaturewithintents;

import java.text.DecimalFormat;

import com.is413.temperature.Celsius;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CelsiusActivity extends Activity {
	
	private EditText editText;
	private Button buttonSubmit;
	private Button buttonToFahrenheit;
	private TextView tvConverted;
	private Celsius celsius; 
	
	private static final String TAG = "IS413 Fahrenheit";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_celsius);
		
		editText = (EditText)findViewById(R.id.editText); 
		tvConverted =(TextView)findViewById(R.id.tvConverted); 
		buttonSubmit = (Button)findViewById(R.id.buttonSubmit); 
		buttonToFahrenheit = (Button)findViewById(R.id.buttonToFahrenheit); 
		
		buttonSubmit.setOnClickListener(new ButtonListener());
		buttonToFahrenheit.setOnClickListener(new FahrenheitListener());
		
		
		Log.i(TAG, "Celsius Activity created"); 
	}
	
	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			String string; 
			DecimalFormat df = new DecimalFormat("####.##");
			float f;
			
			// get the entered temperature 
			// TODO - is it a number ?
			string = editText.getText().toString(); 
			celsius = new Celsius(string); 
			f = new Float(celsius.convert()); 
			tvConverted.setText("Temperature in Celsius: "+
								df.format(f));	
		}
	}
	
	/*
	 * Use an an Intent to switch to the Celsius Activity
	 */
	private class FahrenheitListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(CelsiusActivity.this, 
					FahrenheitActivity.class); 
			startActivity(intent); 
		}
		
	}

	
} ///~
