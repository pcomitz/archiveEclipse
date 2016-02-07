package com.is413.myfirstdraw;

import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/*
 * This class extends the View class. 
 * Note the three constructors. They are
 * added when by Eclipse when 
 * automatically "Constructors from superclass" is 
 * selected 
 */

public class MyView extends View 
{
	private Paint paint = new Paint(); 
	private int width; 
	private int height; 
	private final int RADIUS = 100; 
	private final String TAG = "MyView"; 

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * onDraw() draws the view. It is called when:
	 * 	- app is launched
	 *  - screen rotation
     *  - view is covered and uncovered 
     *  - invalidate() is called
     *  - postInvalidate() is called non-UI thread
	 */
	@Override 
	public void onDraw(Canvas canvas)
	{
		// get the width and height of the view
		width = getMeasuredWidth(); 
		height = getMeasuredHeight(); 
		Log.i(TAG,"in onDraw(), height is:"+height+" width is:"+width); 
		
		//  set the color to paint
		paint.setColor(Color.BLUE); 
		
		// draw a circle of radius RADIUS using the paint color
		canvas.drawCircle(
				width/2, height/2, RADIUS, paint);
	}

} ///~
