package com.itheima.pressure;

import java.util.Random;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	{
		System.loadLibrary("ithiema50");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final PressureView view = new PressureView(this);
//		view.setPressure(190);
		setContentView(view);
		
		new Thread(){
			public void run() {
				Random random = new Random();
				while(true){
					SystemClock.sleep(1000);
//					int pressure = Math.abs(random.nextInt()%210);
//					System.out.println("random.nextInt()="+random.nextInt()%250);
					int pressure = getPressure();
				    view.setPressure(pressure);
				    if(pressure >210){
				    	break;
				    }
					
				}
			};
		}.start();
		
		uninstalllistener();
	}

	/**
	 * �õ���¯ѹ��ֵ
	 * @return
	 */
	public native int getPressure();
	
	/**
	 * ���������Ƿ�ж��
	 */
	public native void uninstalllistener();

	

}
