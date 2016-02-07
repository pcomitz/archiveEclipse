package com.phcradiodialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView  tv; 
	AlertDialog alert; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView)findViewById(R.id.tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.experience) {
			buildAlert();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void buildAlert()
	{
		String[] items = {"Advanced", "Intermediate", "Beginner"}; 
		
		//-1 indicates noting selected 
		int initialChecked = -1;
		
		AlertDialog.Builder builder = 
				new AlertDialog.Builder(this);
		
		builder.setTitle("Experience Level"); 
		builder.setSingleChoiceItems(items, initialChecked, new MyDialogListener());
		
		
		//setup the neutral choice
		builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//click causes the dialog to be dismissed
			}
		}		
		); 
		
		//show the dialog
		builder.show(); 
	}
	
	private class MyDialogListener implements DialogInterface.OnClickListener
	{
		@Override
		public void onClick(DialogInterface dialog, int which) {
			
			// which item was selected 
			switch(which)
			{
				case 0:
					tv.setText("Advanced");
					break;
					
				case 1:
					tv.setText("Intermediate");
					break;
					
				case 2:
					tv.setText("Beginner");
					break;
						
				default:
					break;
			}
			
			
		}
	}
} ///!
