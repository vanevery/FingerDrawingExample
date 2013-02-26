package com.mobvcasting.fingerdrawingexample;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	DrawingView drawingView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawingView = (DrawingView) this.findViewById(R.id.drawingView);
		// Do something more if you want...
	}
}

