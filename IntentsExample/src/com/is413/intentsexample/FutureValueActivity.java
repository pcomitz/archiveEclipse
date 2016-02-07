package com.is413.intentsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class FutureValueActivity extends Activity {

	private Button returnButton;	
	private TextView tv; 
	private static final String TAG = "IS413";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_future_value);
		
		//get the data from the intent
		Intent intent = getIntent();
		
		double rate = intent.getDoubleExtra("rate", 6.0); 
		Log.v(TAG, "FutureValueActivity rate in percent is:"+rate);
		
		// rate is entered in percent, divide by 100 for use in future value calculation
		rate /= 100; 
		
		double pv = intent.getDoubleExtra("pv", 1000.0);  
		Log.v(TAG,"Present Value is:"+pv);
		int compound = Integer.valueOf(intent.getStringExtra("compound")).intValue();
		intent.getIntExtra("compound", 10); 
		Log.v(TAG,"Number of compounding periods is:"+compound);
		
		//compute the future value 
		Double fv = pv*Math.pow(1+rate,compound); 
		
		//format and display the future value
		DecimalFormat df = new DecimalFormat("#0.00"); 
		
		//String s = fv.toString();
		tv = (TextView)findViewById(R.id.futureValueText); 
		
		tv.setText("Future Value: $"+df.format(fv));
		
		returnButton = (Button)findViewById(R.id.returnButton); 
		returnButton.setOnClickListener(new ReturnListener(this));
	}
}
