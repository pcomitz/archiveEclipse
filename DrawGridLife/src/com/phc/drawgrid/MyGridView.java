package com.phc.drawgrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* 
 * The main view for the game of Life. 
 */
public class MyGridView extends View {
	
	private Paint paint = new Paint(); 
	private int width; 
	private int height; 
	private final String TAG = "DrawGridLife"; 
	private int nrow = 0; 
	private int ncol = 0; 
	private char[][] generation; 
	private int genCount = 0; 

	public MyGridView(Context context) {
		super(context);
		
	}

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// This constructor must be present for XML attributes to be 
		// be applied 
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(TAG, " ctor, width is: "+width+" , height is: +"+height);
	}

	/*
	 * You can use ctrl-space to find the method stub
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// how big is the view 
		width = this.getMeasuredWidth(); 
		height = this.getMeasuredHeight(); 
		Log.v(TAG, " onDraw width is: "+width+" , height is:+"+height);
		Log.v(TAG, "width/10 : "+width/10+ " height/10 : "+ height/10);  
		
		// set the paint
		paint.setColor(Color.RED); 
		
		//populate the grid
		for(int r = 0; r < nrow; r++)
		{
			//Log.v(TAG, "onDraw : nrow :"+nrow+",ncol:"+ncol+",r is :"+r); 
			for(int c = 0; c < ncol; c++)
			{
				//Log.v(TAG, "onDraw, c  is :"+c); 
				if(this.generation[r][c] == '*')
				{
					//left, top, right, bottom
					canvas.drawRect(c*10, r*10, ((c*10)+9), ((r*10)+9), paint);
				}
			}
		}
		
		// write the generation count
		paint.setColor(Color.BLUE); 
		paint.setTextSize(24); 
		canvas.drawText(String.valueOf(genCount), 10.0f, (float)height-20, paint); 
	} //onDraw

	/* get an instance of this view */ 
	public MyGridView getInstance() { 
		return this; 
	}
	
	/* set the number of rows and columns */ 
	public void setRowCol(int nrow, int ncol) {
		this.nrow = nrow; 
		this.ncol = ncol; 
		Log.v(TAG, "setRowCol: nrow:"+this.nrow+" ncol:"+this.ncol); 
		this.generation = new char[ncol][nrow];
	}
	
	/* set the pattern - this demo simply 
	 * sets a glider 
	 */
	public void setPattern(String pattern)
	{
		this.generation = new char[nrow][ncol];
		Log.v(TAG, "setPattern: nrow:"+this.nrow+" ncol:"+this.ncol); 
		
		//initialize the grid
		for(int r = 0; r < nrow; r++)
			for(int c =0; c < ncol; c++)
				this.generation[r][c] = ' ';
		
		if(pattern.equals("glider"))
		{
			this.generation[1][3] = '*';
			this.generation[2][1] = '*';
			this.generation[2][3] = '*';
			this.generation[3][2] = '*';
			this.generation[3][3] = '*';
		}
	}
	
	/* cause onDraw() */
	public void causeInvalidate() {
		this.invalidate();
	}
	
	/* set the generation count */
	public void setGenCount(int count) { 
		this.genCount = count; 
	}
	
	/* set next generation */
	public void setGeneration(char[][] generation) {
    for (int r =0; r < nrow; r++)
		for(int c =0; c < ncol; c++)
			this.generation[r][c] = generation[r][c]; 
    
		Log.v(TAG,"MyGridView: set generation"); 
	}
	
	/* get current generation */
	public char[][] getCurrentGeneration()
	{
		// TODO check for null 
		return generation; 
	}
	
} ///~
