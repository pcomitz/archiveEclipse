package com.is413.simpledrawrect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



public class DrawCanvas extends View {
	
	private Paint paint = new Paint(); 

	public DrawCanvas(Context context) {
		super(context);
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		//drawRect(float left, float top, float right, float bottom, Paint paint)
		paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawRect(30, 30, 80, 80, paint);
        
        //try another
        canvas.drawRect(80, 80, 130, 130, paint);
        
        canvas.drawRect(0, 0, 30, 30, paint);
        
        canvas.drawRect(80, 80, 130, 130, paint);
        
        canvas.drawRect(429, 670, 479, 720, paint);
        
        paint.setColor(Color.RED);
        for (int i = 10; i < 480; i+=10)
        {
        	canvas.drawRect(0, 200, 0+i, 210, paint);
        }
        
        //and another
        //canvas.drawRect(100, 100, 150, 150, paint);
        
       /*
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(33, 60, 77, 77, paint );
        
        paint.setColor(Color.YELLOW);
        canvas.drawRect(33, 33, 77, 60, paint );
		*/
	}
	
	
}
