package com.is413.myfirstdraw;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Activity;


public class MyFirstDrawActivity extends Activity {

	private MyView myView; 
	private final String TAG  = "Draw with Handler"; 
	private Message msg; 
	private final int START_MESSAGE = 0; 
	private final int STOP_MESSAGE = 2; 
	private final long delayMillis = 1000;
	private RefreshHandler refreshHandler; 
	private boolean isRunning = false; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myView = new MyView(this); 
		refreshHandler = new RefreshHandler(myView); 
		setContentView(myView);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// inflate the menu
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	     
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		switch(item.getItemId())
		{
			case R.id.startItem:
			{
				Log.v(TAG, "start item"); 
				isRunning = true; 
				refreshHandler.sendMessageDelayed(refreshHandler.obtainMessage(START_MESSAGE), delayMillis);
				break;
			}
			case R.id.stopItem:
			{ 
				isRunning = false; 
				Toast.makeText(getApplicationContext(), "I'm alive", Toast.LENGTH_SHORT).show();
				Log.v(TAG, "stop item"); 
				break; 
			}
			default:
			{
				Log.v(TAG, "default"); 
				break; 
			}
			
		}
		
		return super.onOptionsItemSelected(item);
	}
}
