package com.example.javacallcdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private JNI jni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jni = new JNI();
    }
public void javaCallCFoAdd(View view){
		
		int result = jni.add(18, 20);
		System.out.println("result=="+result);
		Toast.makeText(getApplicationContext(), "result=="+result, 1).show();
	}
	
	public void javaCallCFoString(View view){
		String result = jni.sayHelloInC("I am from java ");
		System.out.println("result=="+result);
		Toast.makeText(getApplicationContext(), "result=="+result, 1).show();
	}
	
	public void javaCallCFoArray(View view){
		int[] array = {1,2,3,4,5,6};
		int [] result = jni.arrElementsIncrease(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
