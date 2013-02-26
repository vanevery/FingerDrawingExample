package com.mobvcasting.fingerdrawingexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

// We are extending ImageView so that we can have a persistent Bitmap and the means to display it
public class DrawingView extends ImageView implements OnTouchListener {
    
	public final static String LOGTAG = "DrawingView";
	
	Bitmap bitmap;
	Paint paint;
	Canvas canvas;

	float downX = 0;
	float downY = 0;
	float upX = 0;
	float upY = 0;
	
	public DrawingView(Context context) {
        super(context);
    }
	
	public DrawingView(Context context, AttributeSet attrs) {
		super(context,attrs);
	}
	
	public DrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context,attrs,defStyle);
	}
	
	public void init() {
		
        bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setColor(Color.RED);
        this.setImageBitmap(bitmap);
		this.setOnTouchListener(this);
	}

	@Override 
	protected void onSizeChanged (int w, int h, int oldw, int oldh)
	{
		Log.v(LOGTAG,"onSizeChanged:" + w + " " + h + " " + oldw + " " + oldh);
		if (w != 0 && h != 0) {
			init();
		}
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent motionEvent) {
		
		if (bitmap != null) 
		{
			Log.v(LOGTAG,"onTouch, bitmap isn't null");
			
			int action = motionEvent.getAction();			
			switch (action) {
				case MotionEvent.ACTION_DOWN:
					downX = motionEvent.getX();
					downY = motionEvent.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					break;
				case MotionEvent.ACTION_UP:
					upX = motionEvent.getX();
					upY = motionEvent.getY();
					canvas.drawLine(downX, downY, upX, upY, paint);
					invalidate();
					break;
				case MotionEvent.ACTION_CANCEL:
					break;	
				default: 
					break;
			}			
		} 
		return true;
	}
    
	
	
}