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
	 * ��ǰ��¯��ѹ��ֵ
	 */
	private int pressure;

	public PressureView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public PressureView(Context context) {
		super(context);
		paint = new Paint();
		//�����
		paint.setAntiAlias(true);
		paint.setTextSize(18);
	}
	/**
	 * ���ù�¯ѹ��ֵ��0~250֮��
	 * @param pressure
	 */
	public void setPressure(int pressure){
		this.pressure = pressure;
		if(pressure < 150){//ѹ��С��150����ʾ��ɫ
			paint.setColor(Color.GREEN);
		}else if( pressure < 180){//���ڻ����150������ѹ��С��180����ʾ��ɫ
			paint.setColor(Color.YELLOW);
		}else if(pressure < 200){//���ڻ����180������ѹ��С��2000����ʾ��ɫ
			paint.setColor(Color.RED);
		}else{
			//��������¯��ը��
			paint.setColor(Color.RED);
		}
		
		//���»���
//		invalidate();//ֻ�������߳�
		postInvalidate();//�ķ������������߳���ȾUI
	}
	
	/**
	 * ������ͼ
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		if(pressure < 200){
			canvas.drawRect(20, 250-pressure, 40, 250, paint );
		}else{
			//��¯��ը��
			canvas.drawText("�ո磬���ܣ���¯��Ҫ��ը��...", 0, getHeight()/2, paint);
		}
		
	}
	
	
	

}
