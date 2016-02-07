package com.phc.handlertest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;


public class MyHandler extends Handler {
	
	private final static int SET_COUNT = 0;
	private final static int SET_COUNT_BY_TWO = 1;
	private final static int SET_COUNT_BY_4 = 2;
	private TextView tv; 


	public MyHandler(TextView tv) {
		this.tv=tv; 
	}

	public void handleMessage(Message msg) 
	{
		switch (msg.what) 
		{
			case SET_COUNT: 
			{
				tv.setText((Integer) msg.obj);
				break;	
			}
		}	
	}
}
