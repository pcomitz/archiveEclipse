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

/*
 * Grid with TouchListener
 */
public class GridView extends View {
	
	private Paint paint = new Paint(); 
	private int width; 
	private int height; 
	private ArrayList<Point> arrayList; 
	
	public GridView(Context context) {
		super(context);
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(GridActivityTouch.TAG, "width is: "+width+" , height is: +"+height);
	}

	public GridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public GridView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int cornerX = 0; 
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		
		//width and height
		Log.v(GridActivityTouch.TAG, "onDraw width is: "+width+" , height is:+"+height);
		Log.v(GridActivityTouch.TAG, "width/10 : "+width/10+ " height/10 : "+ height/10);  
		
		// The color-parameter accepts an hex-code in the form 
		// 0xaarrggbb (a=alpha, r=red, g=green, b=blue) 
		// for transparent, can use paint.setColor(0x99000000);
		// for no fill use Paint.Style.Stroke
		paint.setStyle(Paint.Style.STROKE); 
		
		for(int i = 0 ; i < width/10; i++)
		{
			cornerX = i*10; 
			for(int j = 0; j < height/10; j++)
			{
				//check if touch in this rectangle
				if (checkForPointinRectangle(cornerX, j*10, cornerX+10, (j*10)+10))
				{
					paint.setColor(Color.RED); 
					paint.setStyle(Paint.Style.FILL); 
				}
				else
				{
					paint.setColor(Color.BLUE); 
					paint.setStyle(Paint.Style.STROKE); 
				}
				
				//draw the rectangle 
				canvas.drawRect(cornerX, j*10, cornerX+10, (j*10)+10, paint);
			}
		}		
	} //onDraw
	
	/* get the points for the dynamic line */
	public void setPoints(ArrayList<Point> al)
	{
		this.arrayList = al; 
	}
	
	/* a method to clear the array list */
	public void clearArrayList() {
		arrayList.clear(); 
		invalidate();
	}
	
	/*
	 * This method determines if any of the points in the ArrayList are in the rectangle
	 */
	private boolean checkForPointinRectangle(float left, float top, float right, float bottom)
	{
		boolean foundMatch = false;  
		if (arrayList != null)
		{
			for(Point p : arrayList )	
			{
				if((p.x >= left)&& (p.x < right) && (p.y >= top) && (p.y< bottom))
				{
					foundMatch = true;
					Log.v(GridActivityTouch.TAG, "found match:"+left+","+top+","+right+","+bottom);
				}
			}	
		}
		return foundMatch; 
	}
	
} ///~
