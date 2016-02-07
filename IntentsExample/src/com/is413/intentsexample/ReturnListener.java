package com.is413.intentsexample;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/*
 * There are many ways to implement listeners. We have 
 * been using named inner classes. This 
 * is just an example of another way 
 */
public class ReturnListener implements OnClickListener {

	private Activity activity; 
	
	public ReturnListener(Activity activity)
	{
		this.activity = activity;
	}
	@Override
	public void onClick(View view) {
		Intent returnIntent = new Intent(activity, MainActivity.class);
		activity.startActivity(returnIntent);
	}
}
