package com.example.ccallbackjava;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private JNI jni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jni = new JNI();
    }
    public void CCallBackJava_Void(View view){
		jni.callBackJava_helloFromJava();
		
	}
	
	public void CCallBackJava_Add_methode(View view){
		jni.callBackJava_add();
	}
	
	public void CCallBackJava_printString_methode(View view){
		jni.callBackJava_printString();
	}
	
	public void CCallBackJava_Static_methode(View view){
		jni.callBackJava_hello();
	}
}
