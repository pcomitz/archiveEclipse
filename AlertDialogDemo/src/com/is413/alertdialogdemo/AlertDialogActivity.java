package com.is413.alertdialogdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AlertDialogActivity extends Activity {
	protected TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        
        //get ids for widgets
        tv = (TextView)findViewById(R.id.tv);
        Button button1 = (Button)findViewById(R.id.button1);
        
        //set listener
        button1.setOnClickListener(new MyListener(this));
    }
    
    //named inner class for the Button listener
    private class MyListener implements OnClickListener
    {
    	private Context context;
    	
    	private MyListener(Context c)
    	{
    		this.context = c;
    	}

		@Override
		public void onClick(View v) {
			AlertDialog.Builder alertBuilder = 
					new AlertDialog.Builder(context);
			
			//set the title and the message for the dialog
			alertBuilder.setTitle("My Alert Title");
			alertBuilder.setMessage("This is the Alert Message");
			
			// set up the Yes choice
			// note the use of an anonymous class, constructed inside the 
			// parameter list of alertBuilder.setPositiveButton( ... )
			alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					tv.setText("Clicked Yes" );
				}
			}
			);
			
			//setup the No choice
			alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					tv.setText("Clicked No");
				}
			}							
			);
			
			//setup the neutral choice
			alertBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					tv.setText("Clicked Neutral");
					
				}
			}		
			); 
					
			
			alertBuilder.show();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_alert_dialog, menu);
        return true;
    }

    
}
