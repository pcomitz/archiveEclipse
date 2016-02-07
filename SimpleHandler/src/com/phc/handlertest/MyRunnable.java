package com.phc.handlertest;

import android.os.Handler;
import android.os.Message;


/**
 * @author pcomitz
 *
 */
public class MyRunnable implements Runnable {

	private Handler handler; 
	private short mDelay;
	private Message msg; 
	private final static int START_COUNT = 0;
	
	/**
	 * a runnable for use with a Handler 
	 */
	public MyRunnable( Handler handler) {
			this.handler = handler;
			this.mDelay = 1000;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		msg = handler.obtainMessage(START_COUNT); 
		for (int i = 1; i < 11; i++) {
			msg = handler.obtainMessage(START_COUNT,i);
			handler.sendMessage(msg);
			sleep(); 
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(mDelay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	

}
