package com.is413.simpledrawrect;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;

/*
 * http://stackoverflow.com/questions/7344497/android-canvas-draw-rectangle
 */

public class SimpleDraw extends Activity {

	DrawCanvas drawCanvas;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		drawCanvas = new DrawCanvas(this); 
		drawCanvas.setBackgroundColor(Color.WHITE); 
		setContentView(drawCanvas);
	}

	
}
