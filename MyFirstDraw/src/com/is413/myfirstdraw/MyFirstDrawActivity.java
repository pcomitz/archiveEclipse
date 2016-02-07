package com.is413.myfirstdraw;

import android.os.Bundle;
import android.app.Activity;

/*
 * This activity creates an object of type 
 * MyView and set the activity content to 
 * this view 
 */
public class MyFirstDrawActivity extends Activity {

	private MyView myView; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myView = new MyView(this); 
		setContentView(myView);
	}
}
