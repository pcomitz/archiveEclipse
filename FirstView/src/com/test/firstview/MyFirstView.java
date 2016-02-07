package com.test.firstview;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 */

/**
 * @author comitzp
 *
 */
public class MyFirstView extends View {

	/**
	 * @param context
	 */
	public MyFirstView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public MyFirstView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MyFirstView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	 public void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	        
	        Paint paint = new Paint();
	        paint.setColor(Color.rgb(0, 0, 0));
	        paint.setStrokeWidth(10);
	        canvas.drawRect(100, 100, 200, 200, paint);
	        
	        
	        
	        paint.setColor(Color.BLACK);
	        paint.setStrokeWidth(3);
	        canvas.drawRect(30, 30, 80, 80, paint);
	        paint.setStrokeWidth(0);
	        paint.setColor(Color.CYAN);
	        canvas.drawRect(33, 60, 77, 77, paint );
	        paint.setColor(Color.YELLOW);
	        canvas.drawRect(33, 33, 77, 60, paint );

	         
	        
	 }
	

}
