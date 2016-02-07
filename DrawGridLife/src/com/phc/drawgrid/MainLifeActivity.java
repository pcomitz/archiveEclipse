package com.phc.drawgrid;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Activity;


public class MainLifeActivity extends Activity {

	private static final String TAG = "DrawGridLife";
	private LifeAsyncTask lat; 
	private int nrow = 75;
	private int ncol = 75; 
	private int genTime = 100;  
	private MyGridView myGridView; 
	private LifeParams lifeParams;
	private boolean asyncTaskStarted = false; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* get an instance of the GridView */
		myGridView = (MyGridView)findViewById(R.id.myView);  
		
		// all happens after ctor
		myGridView.setRowCol(nrow, ncol); 
		myGridView.setPattern("glider"); 
		
		lifeParams = new LifeParams(myGridView, nrow, ncol, genTime, "glider"); 
		lat = new LifeAsyncTask(lifeParams); 	
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
			case R.id.start_menu_item:
			{
				Log.v(TAG, "start menu item"); 
				Toast.makeText(getApplicationContext(), R.string.start_string, 
						Toast.LENGTH_LONG).show();
				startLife(); 
				return true; 
			}	
			case R.id.stop_menu_item:
			{
				Log.v(TAG, "stop menu item"); 
				Toast.makeText(getApplicationContext(), R.string.stop_string, 
						Toast.LENGTH_LONG).show();
				stopLife(); 
				return true; 
			}	
			case R.id.quit_menu_item :
			{
				Toast.makeText(getApplicationContext(), R.string.quit_string, 
						Toast.LENGTH_LONG).show();
				quitLife(); 
				return true; 
			}	
			default :
				return super.onOptionsItemSelected(item);
		}
	}
	
	/* quit the game of life */
	private void quitLife() {
		lat.setQuit(true); 
		Log.v(TAG, "MainLifeActivity set quit"); 
	}

	/* stop (pause) the game */
	private void stopLife() {
		lat.setRun(false); 
	}

	/* start or restart the game of life*/
	private void startLife() {
		lat.setRun(true); 
		if(!asyncTaskStarted)
		{
			lat.execute(lifeParams); 
			asyncTaskStarted = true; 
		}
		Log.v(TAG, " startLife()"); 
	}	
	
	@Override
	protected void onResume() {
		super.onResume();
		int h = this.myGridView.getHeight();
		int w = this.myGridView.getWidth();
		Log.v(TAG, "onResume(), h is :"+h+" w is:"+w);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		int h = this.myGridView.getMeasuredHeight();
		int w = this.myGridView.getMeasuredWidth();
		Log.v(TAG, "onWindowFocusChanged(), h is :"+h+" w is:"+w);
	}
	
}///~
