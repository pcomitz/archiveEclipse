package com.phc.frag;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/*
 * A listener for the MainActivity radio buttons
 * a new fragment is created with each button click 
 * this app is for illustration only 
 * 
 */

public class TempListener implements OnClickListener {
	
	Activity activity; 
	
	private final static String TAG = "IS413 TempListener"; 
	
	public TempListener(Activity a) {
		this.activity = a; 
	}
	
	@Override
	public void onClick(View view) {
		
		// get the EditText here because the view is associated with the Activity 
		EditText tempEdit = (EditText)activity.findViewById(R.id.editText); 
		String enteredTemp = tempEdit.getText().toString(); 
		
		if(enteredTemp.equals(""))
			enteredTemp = "100"; 
		Log.d(TAG, "Entered temp is: "+enteredTemp); 
		
		if(view.getId() == R.id.celRadio)
		{
			//Celsius 
			Log.d(TAG, "got the celsius radio") ;
			activity.getFragmentManager().beginTransaction().
			replace(R.id.container, 
					new CelsiusFragment(enteredTemp)).commit();
		}
		else
		{
			//Fahrenheit
			Log. d(TAG, "got view.getId()"+view.getId());
			activity.getFragmentManager().beginTransaction().
			replace(R.id.container, 
					new FahrenheitFragment(enteredTemp)).commit(); 
		}
		
		
	}
} ///~
