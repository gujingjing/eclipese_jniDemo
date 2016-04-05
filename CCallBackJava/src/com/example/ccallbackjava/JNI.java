package com.example.ccallbackjava;

public class JNI {
	{
		System.loadLibrary("CCallBackJava");
	}
	
	/**
	 * C调用java空方法
	 */
	public void helloFromJava(){
		System.out.println("helloFromJava--我被C代码调用了");
	}
	/**
	 * C调用java中的带两个int参数的方法
	 */
	public int add(int x,int y) {
		int result = x + y;
		System.out.println("add(int x,int y)--我被C代码调用了="+result);
		return result;
	}
	/**
	 * C调用java中参数为string的方法
	 */
	public void printString(String s){
		System.out.println("printString--我被C代码调用了="+s);
	}
	
	/**
	 * C调用java中静态hello的方法
	 */
	public static void hello(){
		
		System.out.println("hello--我是静态方法 我被C代码调用了=");
	}
	
	
	/**
	 * 让C代码调用Java代码JNI中的helloFromJava()
	 */
	public native void callBackJava_helloFromJava();
	
	/**
	 * 让C代码调用Java代码JNI中的add(int x,int y) 
	 */
	public native void callBackJava_add();
	
	/**
	 * 让C代码调用Java代码JNI中的printString(String s) 
	 */
	public native void callBackJava_printString();
	
	/**
	 * 让C代码调用Java代码JNI中的静态方法hello() 
	 */
	public native void callBackJava_hello();


}
