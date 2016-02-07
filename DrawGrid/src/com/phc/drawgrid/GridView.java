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
		
		//log width and height
		Log.v(TAG, "onDraw width is: "+width+" , height is:+"+height);
		Log.v(TAG, "width/10 : "+width/10+ " height/10 : "+ height/10);  
		
	
		paint.setColor(Color.BLUE); 
		
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
				canvas.drawRect(cornerX, j*10, cornerX+10, (j*10)+10, paint);
			}
		}
		
	}
}
