package com.phc.myfirstfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.Activity;
import android.app.FragmentManager; 		//use support version for priority
import android.app.FragmentTransaction; 	//support.v4 for earlier versions

public class MainActivity extends Activity {
	
	private DefaultFragment df; 
	private CelsiusFragment cf;
	private FahrenheitFragment ff;
	private RadioButton fRadio; 
	private RadioButton cRadio; 
	private RadioButton dRadio; 
	private EditText editText;
	private FragmentManager fm; 
	private final String TAG = "My First Fragments";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create the default fragment 
		df = new DefaultFragment(); 
		
		// get a reference to the FragmentManager 
		fm = getFragmentManager(); 	
		
		// add the default fragment to the fragment container 
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.fragmentContainer, df);
		ft.commit();

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
			String enteredTemp = editText.getText().toString(); 
			
			/*
			 * if no temperature has been enterd, use a default
			 */
			if((!dRadio.isChecked()) && (enteredTemp.equals("")))
			{
				enteredTemp = "100";
				Toast.makeText(MainActivity.this, "No Temperature entered using" +
						" default of 100",  Toast.LENGTH_LONG).show(); 	
			}
			
			// for later use 
			FragmentTransaction ft = fm.beginTransaction();
			
			// fahrenheit radio selected  
			if(fRadio.isChecked())
			{
				Log.v(TAG, "Fahrenheit checked"); 
				
				//has the fragment already been created ? 
				if(ff != null)
				{
					ft.replace(R.id.fragmentContainer, ff);
					ft.commit();
					ff.setTemperature(enteredTemp);
					ff.setResult();
				}
				else
				{
					//ff is null, create a FahrenheitFragment
					ff = new FahrenheitFragment(enteredTemp); 
					ft.replace(R.id.fragmentContainer, ff);
					ft.commit();
				}
			}
			
			//celsius radio 
			if(cRadio.isChecked())
			{
				Log.v(TAG, "Celsius checked"); 
				// has the fragment been created ? 
				if(cf != null)
				{
					ft.replace(R.id.fragmentContainer, cf);
					ft.commit();
				}	
				else
				{
					// cf is null, create CelsiusFragment 
					cf= new CelsiusFragment(enteredTemp); 
					ft.replace(R.id.fragmentContainer, cf); 
					ft.commit();
				}
			}
		
			// default fragment 
			if(dRadio.isChecked())
			{
				Log.v(TAG,"Default checked"); 
				if(df != null)
				{		
					ft.replace(R.id.fragmentContainer, df);
					ft.commit();
				}		
			}
				
		}//onClick
	}///~~	
} ///~
