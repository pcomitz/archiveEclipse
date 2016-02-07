package com.is413.basiclistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BasicListViewActivity extends Activity {

	protected ListView listView; 
	public final static String TAG = "BasicListView"; 
	// add two weeks worth of days to demonstrate scrolling in ListView
	protected String[] myArray = {"Monday", "Tuesday", "Wednesday", "Thursday", 
								"Friday", "Saturday", "Sunday",
								"Monday", "Tuesday", "Wednesday", "Thursday", 
								"Friday", "Saturday", "Sunday"}; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);
        
        //set up the ListView and the adapter
        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = 
        		new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArray);
        listView.setAdapter(arrayAdapter);
        listView.setClickable(true);
        
        //set the callback
        listView.setOnItemClickListener(new MyListener(this));
    }
    protected class MyListener implements OnItemClickListener
    {
    	private Context context; 
    	
    	public MyListener(Context context)
    	{
    		this.context = context;
    	}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			// which list item was clicked ? 
			Object obj = listView.getItemAtPosition(position);
			
			//viewable in Eclipse via LogCat
			Log.v(TAG, "Clicked on :"+obj.toString());
			
			Toast toast = Toast.makeText(context, obj.toString(), Toast.LENGTH_SHORT);
			toast.show();
		}
    }
} ///~

