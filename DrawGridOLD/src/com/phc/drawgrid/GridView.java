package com.phc.drawgrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GridView extends View {
	
	private Paint paint = new Paint(); 
	private int width; 
	private int height; 
	private final String TAG = "My Log Tag"; 

	public GridView(Context context) {
		super(context);
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(TAG, "width is: "+width+" , height is: +"+height);
	}

	public GridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public GridView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * You can use ctrl-space to find the method stub
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int cornerX = 0; 
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(TAG, " onDraw width is: "+width+" , height is:+"+height);
		Log.v(TAG, "width/20 : "+width/20+ " height/20 : "+ height/20);  
		
		
		paint.setColor(Color.RED); 
		for(int i = 0 ; i < width/20; i+=2)
		{
			cornerX = i*20; 
			for(int j = 0; j < height/20; j+=2)
			{
				//canvas.drawRect(i, j*20, i+20, (j*20)+20, paint);
				canvas.drawRect(cornerX, j*20, cornerX+20, (j*20)+20, paint);
			}
		}
		
	}

}
