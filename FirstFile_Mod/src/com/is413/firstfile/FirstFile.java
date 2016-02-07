package com.is413.firstfile;

import java.io.File;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Modified for Fall 2013
 * Read the files from the directory data/data/patterns
 * This directory must be present on the emulator or the 
 * device
 * The path is identified in  res/values/strings.xml
 */
public class FirstFile extends Activity 
{
	private TextView tvPath;
	private ListView listView; 
	public static final String MYTAG = "My Tag:"; 
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	//local
    	ArrayList<String> fileNamesList = new ArrayList<String>(); 
    	File root; 
    	File[] files; 
    	
    	//normal onCreate processing
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_file);
        
        // get references 
        tvPath = (TextView)findViewById(R.id.textViewPath); 
        listView = (ListView)findViewById(R.id.listView); 
          
        //set directory path for files and display as TextView
        root = new File(this.getString(R.string.path)); 
        tvPath.setText(this.getString(R.string.path)); 
        
        // for illustration only 
        // verify that the File object file is a directory
        if(root.isDirectory())
        {
        	Log.v(MYTAG,"root is a directory"); 
        	Log.v(MYTAG,"the directory is:"+root.getPath()); 
        }
        else
        {
        	Log.v(MYTAG,"file name is:"+root.getName()); 
        	Log.v(MYTAG,"file path is:"+root.getPath()); 
        }

        // get a reference to all files in the directory
        files = root.listFiles();
        
        // are any file present in the directory ? 
        if(files != null) 
        {
        	Log.v(MYTAG,"The number of  of entries in the directory is:"+files.length);
        
	        //put the filenames in the ArrayList<String>
	        for(int i =0; i < files.length; i++)
	        {
	        	fileNamesList.add(files[i].getName()); 
	        	Log.v(MYTAG,"file is:"+fileNamesList.get(i));
	        }
        }
        
        //set the adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
        				(this,android.R.layout.simple_list_item_1, fileNamesList);
        listView.setAdapter(adapter);
        
        //set the callback for the listView
        listView.setClickable(true); 
        listView.setOnItemClickListener( new MyItemListener()); 
        listView.setOnItemLongClickListener(new MyLongClickItemListener()); 

    }//onCreate
    
    /*
     * callback for normal clicks 
    */    
    private class MyItemListener implements OnItemClickListener
    {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long rowID) 
		{
			//get the item that was clicked
			Object obj = listView.getItemAtPosition(position); 
			
			//show Toast for list item that was clicked
	        Toast toast = Toast.makeText(FirstFile.this, obj.toString(), Toast.LENGTH_LONG);
	        toast.show();
		}	
    }
    /*
     * callback for long clicks 
    */
    private class MyLongClickItemListener implements OnItemLongClickListener
    {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long rowID) 
		{
			//get the item that was clicked
			Object obj = listView.getItemAtPosition(position); 
			
			//show Toast for list item that was clicked
	        Toast toast = Toast.makeText(FirstFile.this, "Long click :"+obj.toString(), Toast.LENGTH_LONG);
	        toast.show();
			
			return true;
		}
    }
} ///~
