package com.phc.myfirstfragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; 
import android.widget.TextView;
import is413Temperature.Fahrenheit;

public class FahrenheitFragment extends Fragment {

	private TextView tvResult;  
	private String temperature; 
	private Fahrenheit fahrenheit;
	View view; 
	
	public FahrenheitFragment(String s) 
	{
		this.temperature =s;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) 
	{
		//inflate the view
	    view = inflater.inflate(R.layout.fahrenheit_fragment,
	        container, false); 
	    
	    setResult(); 
	    return view;
	  }
	
	public void setTemperature(String s) { 
		this.temperature = s;
	}
	
	public void setResult()
	{
		tvResult = (TextView)view.findViewById(R.id.tvFahrenheitResult); 
	    fahrenheit = new Fahrenheit(temperature);
	    tvResult.setText("The result in celisus is:"+fahrenheit.convert()); 
	}
} ///~
