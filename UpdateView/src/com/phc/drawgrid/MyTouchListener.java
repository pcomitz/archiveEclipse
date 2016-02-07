package com.phc.drawgrid;

import java.util.ArrayList;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyTouchListener implements OnTouchListener 
{
	private MyGridView view; 
	private ArrayList<Point> arrayList; 
	
	public MyTouchListener(MyGridView v)
	{
		this.view = v;
		arrayList = new ArrayList<Point>(); 
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		boolean returnValue = false; 
		Point p = new Point(); 
		
		 switch (event.getAction()) 
		 {
		 	case MotionEvent.ACTION_DOWN:
		 	{
		 		Log.v(MainActivity.MYTAG, "MovtionEvent.ACTION_DOWN"); 
		 		p.x = (int) event.getX(); 
		    	p.y = (int) event.getY();
		 		arrayList.add(p); 
		 		Log.v(MainActivity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
		 		returnValue = true; 
		 		break; 
		 	}
	        case MotionEvent.ACTION_MOVE:
	        {
	        	Log.v(MainActivity.MYTAG, "MovtionEvent.ACTION_MOVE"); 
	        	p.x = (int) event.getX(); 
	        	p.y = (int) event.getY();
	        	arrayList.add(p); 
	        	Log.v(MainActivity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
	        	returnValue = true; 
	        	break; 	
	        }
	        case MotionEvent.ACTION_UP:
		 	{
		 		Log.v(MainActivity.MYTAG, "MovtionEvent.ACTION_UP"); 
		 		p.x = (int) event.getX(); 
		    	p.y = (int) event.getY();
		 		arrayList.add(p); 
		 		Log.v(MainActivity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
		 		
		 		//set the point to be drawn
		 		view.setPoints(arrayList); 
		 		view.invalidate(); 
		 		
		 		returnValue = true; 
		 		break; 
		 	}
		
	        default:
	        	returnValue=  false;
		 	}
		 
		 	return returnValue;
	}	
}
