package com.example.famousquotes;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
	
	FragmentManager fm;
	FragmentTransaction ft;
	Fragment myFragment;
	
	Button brucelee_button, billgates_button, henryford_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		brucelee_button = (Button)findViewById(R.id.button_bruce_lee);
		billgates_button = (Button)findViewById(R.id.button_bill_gates);
		henryford_button = (Button)findViewById(R.id.button_henry_ford);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		if (savedInstanceState == null){
			DefaultFragment myFragment = new DefaultFragment();
			//ft.add(R.id.myFragment, myFragment);
			ft.commit();
		}
		brucelee_button.setOnClickListener(btnOnClickListener);
		billgates_button.setOnClickListener(btnOnClickListener);
		henryford_button.setOnClickListener(btnOnClickListener);
		
	}
	
	Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			Fragment newFragment;
			
			if (v == brucelee_button){
				newFragment = new BruceLeeFragment();
			} else if (v == billgates_button){
				newFragment = new BillGatesFragment();
			} else if (v == henryford_button){
				newFragment = new HenryFordFragment();
			} else {
				newFragment = new DefaultFragment();
			}
			FragmentManager fm1 = getSupportFragmentManager();
			FragmentTransaction ft1 = fm1.beginTransaction();
			//ft1.replace(R.id.myFragment, newFragment)
			//.addToBackStack(null)
			//.commit();
			
		}
	};

	

}
