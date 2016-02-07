package com.is413.myactionbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu); 
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.visible_item :
			{
				Toast.makeText(getApplicationContext(), R.string.visibleItemString, 
				Toast.LENGTH_LONG).show();
			return true; 
			}	
			case R.id.item1 :
			{
				System.out.println("item 1"); 
				Toast.makeText(getApplicationContext(),R.string.item1String,
						Toast.LENGTH_LONG).show();
				return true; 
			}	
			case R.id.item2 :
			{
				System.out.println("item 2"); 
				Toast.makeText(getApplicationContext(), R.string.item2String, 
						Toast.LENGTH_LONG).show();
				return true; 
			}	
			case R.id.item3 :
			{
				Toast.makeText(getApplicationContext(), R.string.item3String, 
						Toast.LENGTH_LONG).show();
				return true; 
			}	
			default :
				return super.onOptionsItemSelected(item);
		}
	}
} ///~
