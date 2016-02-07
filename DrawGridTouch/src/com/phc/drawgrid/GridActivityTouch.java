package com.phc.drawgrid;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class GridActivityTouch extends Activity {

	private GridView myGridView;
	public static final String TAG = "GridActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myGridView = (GridView)findViewById(R.id.myView);
		myGridView.setOnTouchListener(new MyTouchListener(myGridView)); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu); 
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == (R.id.clearGrid))
			myGridView.clearArrayList(); 
		return super.onOptionsItemSelected(item);
	}
}
