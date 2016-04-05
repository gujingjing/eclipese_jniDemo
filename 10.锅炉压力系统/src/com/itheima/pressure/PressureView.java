package com.itheima.pressure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PressureView extends View {
	private Paint paint;
	/**
	 * 当前锅炉的压力值
	 */
	private int pressure;

	public PressureView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public PressureView(Context context) {
		super(context);
		paint = new Paint();
		//抗锯齿
		paint.setAntiAlias(true);
		paint.setTextSize(18);
	}
	/**
	 * 设置锅炉压力值：0~250之间
	 * @param pressure
	 */
	public void setPressure(int pressure){
		this.pressure = pressure;
		if(pressure < 150){//压力小于150，显示绿色
			paint.setColor(Color.GREEN);
		}else if( pressure < 180){//大于或等于150，并且压力小于180，显示黄色
			paint.setColor(Color.YELLOW);
		}else if(pressure < 200){//大于或等于180，并且压力小于2000，显示红色
			paint.setColor(Color.RED);
		}else{
			//其他，锅炉爆炸了
			paint.setColor(Color.RED);
		}
		
		//重新绘制
//		invalidate();//只能在主线程
		postInvalidate();//改方法可以在子线程渲染UI
	}
	
	/**
	 * 绘制视图
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		if(pressure < 200){
			canvas.drawRect(20, 250-pressure, 40, 250, paint );
		}else{
			//锅炉爆炸了
			canvas.drawText("刚哥，快跑，锅炉快要爆炸了...", 0, getHeight()/2, paint);
		}
		
	}
	
	
	

}
