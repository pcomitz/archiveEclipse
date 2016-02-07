package com.phc.drawgrid;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Activity;


/*
 * An example of how to update a view with invalidate()
 * Remember- if you update from another Thread you must 
 * use postInvalidate()
 * 
 * The TouchListerner is used to show how to uodate a View based
 * on Touch gesture
 */

public class MainActivity extends Activity {
	private MyGridView myGridView; 
	private int count; 
	private int INITIAL_COUNT = 10; 
	public final static String MYTAG = "My Tag"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myGridView = (MyGridView)findViewById(R.id.myView); 
	
		//initial count 
		count = INITIAL_COUNT; 
		myGridView.setCount(count); 
		myGridView.setOnTouchListener(new MyTouchListener(myGridView)); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.count_item:
			{
				Toast.makeText(getApplicationContext(), R.string.count_string,
				Toast.LENGTH_LONG).show();
				count += 10;
				myGridView.setCount(count); 
				myGridView.invalidate(); 
			return true; 
			}	
			
			default :
				return super.onOptionsItemSelected(item);
		}
	}
	
	
}///~
