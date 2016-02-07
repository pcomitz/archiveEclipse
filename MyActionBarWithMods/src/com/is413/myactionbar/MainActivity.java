package com.is413.myactionbar;

/*
 * This version includes updates and tweaks
 *  - 11/24/2013
 *  - 3 Menu files, only one in use at a time
 * 	- Action View with EditText and listener
 *  - Nested Menus
 *  Very odd problem with images 
 *  Somehow R.java vanished - had to delete ic_lincoln.png from 
 *  re/menu/presients.xml to rebuild 
 *  Put it back and all is well 
 *  Very odd 
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText editText; 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//getMenuInflater().inflate(R.menu.actionview, menu);
		getMenuInflater().inflate(R.menu.presidents, menu);
		
		// get a reference to the EditText and specify a callback
		// MenuItem editItem = menu.findItem(R.id.visible_item);
	    /*
		editText = (EditText) editItem.getActionView();
	    editText.setText("Enter Text"); 
	    editText.setOnClickListener(new EditListener()); 
	    */
		
		//return true;
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{		
		switch(item.getItemId())
		{
			/*
			case R.id.visible_item :
			{
				str=this.editText.getText().toString();
				Toast.makeText(getApplicationContext(), str, 
				Toast.LENGTH_LONG).show();
			return true; 
			}
			*/	
		
			case R.id.item1 :
			{
				System.out.println("item 1"); 
				Toast.makeText(getApplicationContext(), "Item 1", 
						Toast.LENGTH_LONG).show();
				return true; 
			}	
			case R.id.item2 :
			{
				System.out.println("item 2"); 
				Toast.makeText(getApplicationContext(), "Item 2", 
						Toast.LENGTH_LONG).show();
				return true; 
			}	
			case R.id.item3 :
			{
				Toast.makeText(getApplicationContext(), "Item 3", 
						Toast.LENGTH_LONG).show();
				System.out.println("item 3"); 
				return true; 
			}	
			default :
				return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	private class EditListener implements OnClickListener 
	{

		@Override
		public void onClick(View view) 
		{
			String str; 
			str=editText.getText().toString();
			Toast.makeText(getApplicationContext(), str, 
			Toast.LENGTH_LONG).show();
		}
		
	}

} ///~
