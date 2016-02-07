package com.phc.drawgrid;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyGridView extends View {
	
	private Paint paint = new Paint(); 
	private int width; 
	private int height; 
	private int count = 0;
	private ArrayList<Point> arrayList; 
	private float[] f; 
	
	//some static points to illustrate how canvas.drawPoints works 
	 private float[] myPoints = {100,100, 200, 200, 300,300,400,400, 500,500}; 

	public MyGridView(Context context) {
		super(context);
	}
	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//This draws over the textView - note that the TextView in the layout is painted over
		canvas.drawColor(Color.LTGRAY); 
		
		//how big is our view ? 
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(MainActivity.MYTAG, "onDraw width is: "+width+" , height is:+"+height);
		Log.v(MainActivity.MYTAG, "width/20 : "+width/10+ " height/20 : "+ height/10);  
		
		//set the paint 
		paint.setColor(Color.BLUE); 
		paint.setTextSize(48); 
		
		//draw text on the canvas
		canvas.drawText("Count is:"+count, 200, 50, paint); 
		
		//get the line data 
		if(arrayList != null)
		{
			f = new float[2* (arrayList.size())]; 
			int i = 0; 
			for(Point p : arrayList )	
			{
				f[i++] = p.x; 	
				f[i++] = p.y;
			}
			//clear out the array list 
			 arrayList.clear(); 
		}
		
		  // draw the lines , first the static line
		  paint.setColor(Color.MAGENTA); 
          paint.setStrokeWidth(50);
          canvas.drawPoints(myPoints, paint);
          
          //next the dynamic line
          paint.setColor(Color.BLUE); 
          paint.setStrokeWidth(20);
          if(f !=null)
        	  canvas.drawPoints(f, paint); 
	}
	
	/* get the points for the dynamic line */
	public void setPoints(ArrayList<Point> al)
	{
		this.arrayList = al; 
	}
	/* a method  to set the count */
	public void setCount(int count) { 
		this.count=count; 
	}
	
	

} ///~
