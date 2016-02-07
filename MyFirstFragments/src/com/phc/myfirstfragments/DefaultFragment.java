package com.phc.myfirstfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DefaultFragment extends Fragment {

	public DefaultFragment() {
		System.out.println("Creating DefaultFragment instance"); 
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) 
	{
		//inflate the view
	    View view = inflater.inflate(R.layout.defaut_fragment,
	        container, false);
	    return view;
	  }
	  

}
