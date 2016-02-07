package com.is413.fahrenheitactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.is413.fahrenheitavtivity.R;
import com.is413.temperature.*;

public class FahrenheitActivity extends Activity {
	
	private EditText editText;
	private Button buttonSubmit;
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
		
		buttonSubmit.setOnClickListener(new ButtonListener()); 
	
		Log.i(TAG, "The activity has been created.");
	}
	
	private class ButtonListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			String string; 
			
			// get the entered temperature 
			// TODO - is it a number ?
			string = editText.getText().toString(); 
			fahrenheit = new Fahrenheit(string); 
			tvConverted.setText("Temperature in Celsius: "+
								fahrenheit.convert());
		}
	}//ButtonListener

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
	
}
