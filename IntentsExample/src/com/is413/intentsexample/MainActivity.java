package com.is413.intentsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/*
 * An example of an app that passes data via an Intent
 * The app is a basic calculator that computes the future 
 * value of money based on an present value, interest rate,
 * and number of compounding periods 
 */

public class MainActivity extends Activity {
	
	private Button submitButton; 
	private EditText interestRateEdit; 
	private EditText presentValueEdit;
	private EditText compoundingEdit; 
	private static final String TAG = "IS413";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get references
		submitButton = (Button)findViewById(R.id.submitButton);
		interestRateEdit = (EditText)findViewById(R.id.interestRateEdit); 
		presentValueEdit = (EditText)findViewById(R.id.presentValueEdit);
		compoundingEdit = (EditText)findViewById(R.id.compoundingEdit);
		
		//set the listener
		submitButton.setOnClickListener(new SubmitListener());
	}
	
	private class SubmitListener implements OnClickListener
	{
		@Override
		public void onClick(View view) {
			// get the values from the user
			// TODO: Add defaults and/or check for error
			String rate = interestRateEdit.getText().toString();
			String compound = compoundingEdit.getText().toString();
			String pv = presentValueEdit.getText().toString();
			
			Log.v(TAG, "The rate is:"+rate); 
			
			//create the Intent object
			Intent myIntent = new Intent(MainActivity.this, 
					FutureValueActivity.class);
			
			//pass data with Intent
			myIntent.putExtra("rate", rate); 
			myIntent.putExtra("pv", pv);
			myIntent.putExtra("compound", compound);
			startActivity(myIntent);
			 
		}
	}
}
