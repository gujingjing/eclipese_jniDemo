package com.example.jnifastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	//��̬�����
	{
		System.loadLibrary("jniFastDemo");//���ض�̬���ӿ�
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
    //����¼�-����C����
  	public void javaCallC(){
  		String result = sayHello();
  		System.out.println("result=="+result);
  		Toast.makeText(getApplicationContext(), "result=="+result, 1).show();
  	}
  	
  //дһ��native����-����C����
  	public native String sayHello();
    
}