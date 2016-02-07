package com.phc.drawgrid;

import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GridView myGrid = new GridView(this); 
		setContentView(R.layout.activity_main);
	}


}
