package com.phc.myfirstfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import is413Temperature.Celsius;

public class CelsiusFragment extends Fragment {
	
	private Celsius celsius;
	private TextView tvResult; 
	private String temperature; 

	public CelsiusFragment(String s) 
	{
		this.temperature = s;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) 
	{
		//inflate the view
	    View view = inflater.inflate(R.layout.celsius_fragment,
	        container, false); 
	    
	    tvResult = (TextView)view.findViewById(R.id.tvCelsiusResult); 
	    celsius = new Celsius(temperature);
	    tvResult.setText("The result in fahrenheit is:"+celsius.convert()); 
	    
	    return view;
	  }
}///~
