package com.is413.firstfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class FirstFile extends Activity 
{
	private File file; 
	private BufferedReader bufRead = null;
	private String fileName = "myFile.txt";
	private TextView tv;
	private TextView tvPath; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_first_file);
         
    	//line to read from file 
    	String lineIn; 
    	
        tv = (TextView)findViewById(R.id.textView);
        tvPath = (TextView)findViewById(R.id.textViewPath); 
        
        //create a file to read 
        createFile();
        
        //get the file directory 
        file = this.getFilesDir();
        String path = file.getAbsolutePath();
        System.out.println("The path is:"+path);
        
        //display the absolute path
        tvPath.setText("Application path: " +path); 
        
        //read from the file 
        try
        {
        	bufRead = new BufferedReader(new FileReader(path+"/"+fileName));
        	System.out.println("attempting to read");
        	while ((lineIn = bufRead.readLine()) != null) 
        	{
        		System.out.println(lineIn); 
        		tv.setText(lineIn);
        	}
        }
        catch(IOException ioe)
        {
        	System.out.println(ioe.getMessage());
        }
    }
    
    /*
     * Create a file in the application directory
     */
    public void createFile()
    {
    	FileOutputStream outputStream;
    	Date date = new Date();
    	String string = date.toString() + "\n"; 
    	
    	try
    	{
    		outputStream = openFileOutput(fileName, Context.MODE_APPEND);
    		outputStream.write(string.getBytes());
    		outputStream.close();
    	}
    	catch(IOException ioe)
    	{
    		ioe.printStackTrace();
    	}
    }   
}
