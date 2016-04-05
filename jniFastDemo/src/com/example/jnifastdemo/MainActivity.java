package com.example.jnifastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	//静态代码块
	{
		System.loadLibrary("jniFastDemo");//加载动态链接库
	}
	
	Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button=(Button)findViewById(R.id.btn);
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				javaCallC();
			}
		});
        
    }
    //点击事件-调用C代码
  	public void javaCallC(){
  		String result = sayHello();
  		System.out.println("result=="+result);
  		Toast.makeText(getApplicationContext(), "result=="+result, 1).show();
  	}
  	
  //写一个native方法-调用C代码
  	public native String sayHello();
    
}
