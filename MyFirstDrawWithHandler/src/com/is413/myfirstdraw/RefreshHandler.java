package com.is413.myfirstdraw;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class RefreshHandler extends Handler {
	
	private MyView view; 
	private final int START_MESSAGE = 0; 
	private final int STOP_MESSAGE = 2; 
	private final long delayMillis = 1000;

	 //use a Handler
	public RefreshHandler(MyView view)
	{
		this.view = view; 
	}
    
        @Override
        public void handleMessage(Message msg) {
        	
        	switch(msg.what)
        	{
        		case START_MESSAGE:
        		{
        			view.update();
                    view.invalidate();
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
        
        public void sleep(long delayMillis) 
        {
        	this.removeMessages(START_MESSAGE);
            sendMessageDelayed(obtainMessage(START_MESSAGE), delayMillis);
        }
}
