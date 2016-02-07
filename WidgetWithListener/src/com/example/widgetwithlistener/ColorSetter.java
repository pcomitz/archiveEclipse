package com.example.widgetwithlistener;

import android.view.View;
import android.view.View.OnClickListener;

public class ColorSetter implements OnClickListener {
	
	private int regionColor; 
	private WidgetWithListenerActivity activity;

	public ColorSetter(int regionColor, 
			WidgetWithListenerActivity activity) {
		this.regionColor = regionColor;
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.activity.setRegionColor(this.regionColor);

	}

}
