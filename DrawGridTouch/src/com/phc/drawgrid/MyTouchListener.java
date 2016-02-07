package com.phc.drawgrid;

import java.util.ArrayList;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyTouchListener implements OnTouchListener 
{
	private GridView view; 
	private ArrayList<Point> arrayList; 
	
	public MyTouchListener(GridView v)
	{
		this.view = v;
		arrayList = new ArrayList<Point>(); 
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		boolean returnValue = false; 
		Point p = new Point(); 
		int action = event.getAction();
		
		//check for any DOWN, MOVE, or UP
		if((action == MotionEvent.ACTION_DOWN)||(action == MotionEvent.ACTION_MOVE)||
		  (action == MotionEvent.ACTION_UP))
		{
			p.x = (int) event.getX(); 
	    	p.y = (int) event.getY();
	 		arrayList.add(p); 
	 		Log.v(GridActivityTouch.TAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
	 		
	 		//set the points to be drawn
	 		view.setPoints(arrayList); 
	 		view.invalidate(); 
	 		returnValue = true; 
		}
		
		return returnValue; 
	} //new onTouch
	
} ///~
