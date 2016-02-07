package com.phc.frag;

import java.text.DecimalFormat;

import com.is413.temperature.Fahrenheit;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * This class displays the result of a temperature 
 * conversion in a Fragment. The conversion is
 * from Fahrenheit to Celsius 
 */

public class FahrenheitFragment extends Fragment {
	
	private String temp; 
	private Fahrenheit f; 
	
	public FahrenheitFragment(String f) {
		this.temp = f; 
	}
	
	public FahrenheitFragment() {
	}

	/*
	 * See http://stackoverflow.com/questions/12122624/access-fragment-view-from-activitys-oncreate
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fahrenheit_fragment_main, container,
				false);
		Log.d(com.phc.frag.MainActivity.TAG, "Fahrenheit Fragment"); 
		
		// get the fragment TextView using rootView
		TextView resultText = (TextView) rootView.findViewById(R.id.fahResult);
		
		//create a Fahrenheit object 
		f = new Fahrenheit(temp); 
		
		//create a format object and display the result of the conversion 
		DecimalFormat df = new DecimalFormat("#0.00"); 
		float fl = Float.valueOf(f.convert()); 
		resultText.setText(temp+ " degrees Fahrenheit is "+df.format(fl)+" degrees Celsius");
		
		return rootView;
	}
}
