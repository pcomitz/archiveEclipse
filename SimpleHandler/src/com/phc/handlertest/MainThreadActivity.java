package com.phc.handlertest;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainThreadActivity extends Activity {
	
	private MyHandler myHandler; 
	private TextView countView; 
	private Button stopButton; 
	private boolean doLoop; 
	private int count; 
	private final static int START_COUNT = 0;
	private final static int STOP_COUNT = 2;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_thread);
		countView = (TextView)findViewById(R.id.textView1); 
		stopButton = (Button)findViewById(R.id.button1); 
		doLoop = true; 
		
		MyHandler myHandler = new MyHandler(countView); 
		//mainLoop(); 
		
		new Thread(new MyRunnable(handler)).start(); 
		
		stopButton.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick(View arg0) {
				doLoop = !doLoop; 
				Toast.makeText(getApplicationContext(), "i'm alive", Toast.LENGTH_SHORT).show(); 
			}	
		}); 
	
	}
	
	Handler handler = new Handler() { 
		public void handleMessage(Message msg) 
		{
			switch (msg.what) 
			{
				case START_COUNT: 
				{
					Integer i = (Integer)msg.obj; 
					countView.setText(i.toString());
					break;	
				}
				case STOP_COUNT: 
				{
					break; 
				}
			}	
		}
	}; 
	
	
}
