package com.itheima_mtxxdemo;

import com.mt.mtxx.image.JNI;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView iv_icon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_icon = (ImageView) findViewById(R.id.iv_icon);
	}
	//����¼�-����ͼƬ
	public void lomo(View view){
		
		//1.����ͼƬ���õ����ؾ���-����
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cls);
		//����-���ؾ���
		int[] pixels = new int[bitmap.getWidth()*bitmap.getHeight()];
		bitmap.getPixels(pixels , 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
		
		
		//2.�����鴫��C���룬������д���
		JNI jni = new JNI();
		/**
		 * p1:���ؾ���
		 *  p2����
		 *  p3����
		 */
		jni.StyleLomoHDR(pixels, bitmap.getWidth(), bitmap.getHeight());
		
		//3.���ݴ���������飬���������µ�ͼƬ
		Bitmap newBitmp = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		
		//4.��ʾ�µ�ͼƬ
		iv_icon.setImageBitmap(newBitmp);
		
	}


}