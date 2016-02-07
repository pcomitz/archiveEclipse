package com.phc.myfirstfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.Activity;
import android.app.FragmentManager; 		//use support version for priority
import android.app.FragmentTransaction; 	//support.v4 for earlier versions

public class MainActivity extends Activity {
	
	private DefaultFragment df; 
	private RadioButton fRadio; 
	private RadioButton cRadio; 
	private RadioButton dRadio; 
	private EditText editText;
	private FragmentManager fm = this.getFragmentManager();
	private final String TAG = "My First Fragments";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//check to see if the fragment container already exists 
		df = (DefaultFragment)fm.findFragmentById(R.id.fragmentContainer);
		
		// if it does not,  add the fragment to the container 
		if(df == null)
		{
			df = new DefaultFragment(); 
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.fragmentContainer, 
					df);
			ft.commit();
		}
		
		//get references to activity widgets
		fRadio = (RadioButton)findViewById(R.id.fahrenheit_button); 
		fRadio.setOnClickListener(new TemperatureListener()); 
		cRadio = (RadioButton)findViewById(R.id.celsius_button);
		cRadio.setOnClickListener(new TemperatureListener()); 
		dRadio = (RadioButton)findViewById(R.id.default_button); 
		dRadio.setOnClickListener(new TemperatureListener()); 
		editText = (EditText)findViewById(R.id.tempEditText); 
		
	} //onCreate()
	
	
	private class TemperatureListener implements OnClickListener
	{
		@Override
		public void onClick(View view) 
		{
			if(fRadio.isChecked())
			{
				System.out.println("Fahrenheit checked"); 
				System.out.println("The temperature is:"+editText.getText().toString());
				if(df != null)
				{
					FragmentTransaction ft = fm.beginTransaction();
					
					//ft.add(R.id.fragmentContainer, new TemperatureFragment());
					ft.replace(R.id.fragmentContainer, 
							new FahrenheitFragment(editText.getText().toString()));
					ft.commit();
				}
			}
			else if(cRadio.isChecked())
			{
				Log.v(TAG, "Celsius checked"); 
				Log.v(TAG, "The temperature is:"+editText.getText().toString());
				if(df != null)
				{
					FragmentTransaction ft = fm.beginTransaction();
					
					//ft.add(R.id.fragmentContainer, new TemperatureFragment());
					ft.replace(R.id.fragmentContainer, 
							new CelsiusFragment(editText.getText().toString()));
					ft.commit();
				}			
			}
			else 
			{
				Log.v(TAG,"Default checked"); 
				if(df != null)
				{
					FragmentTransaction ft = fm.beginTransaction();
					
					//ft.add(R.id.fragmentContainer, new TemperatureFragment());
					ft.replace(R.id.fragmentContainer, df);
					ft.commit();
				}			
			}
		}//onClick
	}///~~	
} ///~
