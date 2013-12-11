package com.jacky.compass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class CompassRotateView extends View  implements Runnable{
	Bitmap bitmap = null; 
	int bitmapWidth = 0; 
	int bitmapHeight = 0; 
	float angle = 0.0f; 
	Matrix matrix = new Matrix();
	public CompassRotateView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
        new Thread(this).start(); 
	}
	public CompassRotateView(Context context,AttributeSet attr) {
		super(context,attr);
		// TODO Auto-generated constructor stub
        new Thread(this).start(); 
	}
	public void setAngle(float angle){
		this.angle = angle;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while(!Thread.currentThread().isInterrupted()){ 
	            try{ 
	                Thread.sleep(100); 
	            }catch (InterruptedException e) { 
	                // TODO: handle exception  
	                Thread.currentThread().interrupt(); 
	            } 
	            postInvalidate();  //可以直接在线程中更新界面  
	   } 
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if(bitmap == null){
			bitmap = ((BitmapDrawable)getBackground()).getBitmap();
			bitmapWidth = bitmap.getWidth(); 
			bitmapHeight = bitmap.getHeight();
		}
		matrix.reset(); 
        //matrix.setRotate(angle); //设置旋转
        matrix.setRotate(angle,bitmapWidth/2,bitmapHeight/2); //设置旋转
        CompassRotateView.DrawImage(canvas, bitmap, matrix);
	}
    public static void DrawImage(Canvas canvas,Bitmap _bitmap, Matrix matrix) 
    { 
        /* 绘制图像 */ 
        canvas.drawBitmap(_bitmap,matrix,null); 
    } 
}
