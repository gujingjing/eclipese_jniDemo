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
	//点击事件-出来图片
	public void lomo(View view){
		
		//1.根据图片，得到像素矩阵-数组
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cls);
		//数组-像素矩阵
		int[] pixels = new int[bitmap.getWidth()*bitmap.getHeight()];
		bitmap.getPixels(pixels , 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
		
		
		//2.把数组传入C代码，让其进行处理
		JNI jni = new JNI();
		/**
		 * p1:像素矩阵
		 *  p2：宽
		 *  p3：高
		 */
		jni.StyleLomoHDR(pixels, bitmap.getWidth(), bitmap.getHeight());
		
		//3.根据处理后的数组，重新生成新的图片
		Bitmap newBitmp = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		
		//4.显示新的图片
		iv_icon.setImageBitmap(newBitmp);
		
	}


}
