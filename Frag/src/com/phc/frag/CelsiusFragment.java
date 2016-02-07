package com.phc.frag;


import java.text.DecimalFormat;

import com.is413.temperature.Celsius;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple Fragment subclass. 
 * This class displays the result of a temperature 
 * conversion 
 *
 */
public class CelsiusFragment extends Fragment {
	
	private String temp;  
	private Celsius c; 
	
	public CelsiusFragment() {
		// Required empty public constructor
	}

	public CelsiusFragment(String c) {
		this.temp = c; 
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		
		View rootView = inflater.inflate(R.layout.fragment_celsius, container,
				false);
		Log.d(com.phc.frag.MainActivity.TAG, "Celsius Fragment"); 
		
		// get the fragment TextView using rootView
		TextView resultText = (TextView) rootView.findViewById(R.id.celResult);
		
		//create a Celsius object 
		c = new Celsius(temp); 
		
		DecimalFormat df = new DecimalFormat("#0.00"); 
		float fl = Float.valueOf(c.convert()); 
		resultText.setText(temp+ " degrees Celsius is "+df.format(fl)+" degrees Fahrenheit");
		
		return rootView;
	}

} ///~
