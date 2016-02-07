package com.is413.myfirstdraw;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.app.Activity;
import android.graphics.Color;

public class MyFirstDrawActivityII extends Activity {
	
	private RadioButton redRadio; 
	private RadioButton greenRadio; 
	private RadioButton blueRadio; 
	private Button submitButton; 
	private MyView myView; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// An attribute set will be passed to the view constructor 
		setContentView(R.layout.activity_my_first_draw); 
		
		// get the id of each widget
		submitButton  = (Button)findViewById(R.id.submitButton); 
		redRadio = (RadioButton)findViewById(R.id.redRadio); 
		greenRadio = (RadioButton)findViewById(R.id.greenRadio); 
		blueRadio = (RadioButton)findViewById(R.id.blueRadio); 
		
		// get the id of the custom view 
		myView =(MyView)findViewById(R.id.myView);
		
		// set the listener per usual
		submitButton.setOnClickListener(new MyListener());
	}
	
	private class MyListener implements OnClickListener 
	{
		@Override
		public void onClick(View v) 
		{
			// Set the custom view color based on 
			// the selected radio
			if(redRadio.isChecked())
			{
				myView.setColor(Color.RED);
			}
			else 
				if (greenRadio.isChecked())
				{
					myView.setColor(Color.GREEN);
				}
				else
					if(blueRadio.isChecked())
					{
						myView.setColor(Color.BLUE);
					}
			
			// calling invalidate() will cause the custom view to be redrawn
			// by calling the onDraw() method of the custom view
			myView.invalidate();
			
		}	//onClick
	} //MyListener
	
} ///~
