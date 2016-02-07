package com.example.widgetwithlistener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class WidgetWithListenerActivity extends Activity {

	private View mColorRegion; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_with_listener);
        
        this.mColorRegion = findViewById(R.id.color_region);
        Button b1 = (Button)findViewById(R.id.button1);
        RadioButton r1 = (RadioButton)findViewById(R.id.radio_button1);
        Button b2 = (Button)findViewById(R.id.button2);
        RadioButton r2 = (RadioButton)findViewById(R.id.radio_button2);
        Button b3 = (Button)findViewById(R.id.button3);
        RadioButton r3 = (RadioButton)findViewById(R.id.radio_button3);
        Button b4 = (Button)findViewById(R.id.button4);
        RadioButton r4 = (RadioButton)findViewById(R.id.radio_button4);
        
        //assign the listener
        b1.setOnClickListener(new ColorSetter(Color.RED, this));
        r1.setOnClickListener(new ColorSetter(Color.RED, this));
        b2.setOnClickListener(new ColorSetter(Color.BLUE, this));
        r2.setOnClickListener(new ColorSetter(Color.BLUE, this));
        b3.setOnClickListener(new ColorSetter(Color.GREEN, this));
        r3.setOnClickListener(new ColorSetter(Color.GREEN, this));        
        b4.setOnClickListener(new ColorSetter(Color.YELLOW, this));
        r4.setOnClickListener(new ColorSetter(Color.YELLOW, this));     
        
       
    }
    
    public void setRegionColor(int color) {
    	this.mColorRegion.setBackgroundColor(color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_widget_with_listener, menu);
        return true;
    }

    
}
