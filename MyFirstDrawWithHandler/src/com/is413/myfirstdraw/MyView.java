package com.is413.myfirstdraw;



import android.content.Context;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MyView extends View 
{
	private Paint paint = new Paint(); 
	private int count = 0; 
	private float TEXT_SIZE = 36.0f; 
	
	
	public MyView(Context context) {
		super(context);
	}

	@Override 
	public void onDraw(Canvas canvas)
	{
		paint.setColor(Color.BLUE); 
		paint.setTextSize(TEXT_SIZE); 
		
		// canvas.drawCircle(cx, cy, radius, paint)
		canvas.drawCircle(
				getMeasuredWidth()/2, getMeasuredHeight()/2, 100, paint);
		
		canvas.drawText("count:"+count, 10, 30,paint); 
		count++;
	}

	
	 /*
     * Handles the basic update loop, 
     */
    public void update() 
    {
    		/*
        	 * DO LIFE RULES 
             */
    	invalidate(); 
    }
    
   

    //use a Handler
    /*
    private class RefreshHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
        	
        	switch(msg.what)
        	{
        		case START_MESSAGE:
        		{
        			update();
                    invalidate();
                    break; 
        		}
        		case STOP_MESSAGE:
        		{
        			break; 
        		}
        		default:
        		{
        			break;
        		}
        	}
           
        }

        public void sleep(long delayMillis) {
        	this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }
    */

    
	
	
} ///~
