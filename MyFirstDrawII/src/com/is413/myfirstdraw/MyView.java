package com.is413.myfirstdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MyView extends View 
{
	Paint paint = new Paint(); 
	int color = Color.BLUE; 
	final int RADIUS = 100; 
	
	/* 
	 * Constructor that is called when inflating a view from XML. 
	 * This is called when a view is being constructed from an XML file, 
	 * supplying attributes that were specified in the XML file. 
	 */
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}	
	
	@Override 
	public void onDraw(Canvas canvas)
	{
		paint.setColor(color); 
		
		//draw of circle of radius RADIUS in te center of the view
		canvas.drawCircle(
				getMeasuredWidth()/2, getMeasuredHeight()/2, RADIUS, paint);
	}
	
	// set the color for the circle 
	public void setColor(int c)
	{
		this.color = c;
	}

} ///~
