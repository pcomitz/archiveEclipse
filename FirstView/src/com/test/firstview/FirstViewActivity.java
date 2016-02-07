package com.test.firstview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FirstViewActivity extends Activity {

	private MyFirstView mfv; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_view);
		
		mfv = (MyFirstView)findViewById(R.id.myfirstview); 
		mfv.invalidate();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_view, menu);
		return true;
	}

}
