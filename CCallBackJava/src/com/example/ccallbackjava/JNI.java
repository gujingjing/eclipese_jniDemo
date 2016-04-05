package com.example.ccallbackjava;

public class JNI {
	{
		System.loadLibrary("CCallBackJava");
	}
	
	/**
	 * C����java�շ���
	 */
	public void helloFromJava(){
		System.out.println("helloFromJava--�ұ�C���������");
	}
	/**
	 * C����java�еĴ�����int�����ķ���
	 */
	public int add(int x,int y) {
		int result = x + y;
		System.out.println("add(int x,int y)--�ұ�C���������="+result);
		return result;
	}
	/**
	 * C����java�в���Ϊstring�ķ���
	 */
	public void printString(String s){
		System.out.println("printString--�ұ�C���������="+s);
	}
	
	/**
	 * C����java�о�̬hello�ķ���
	 */
	public static void hello(){
		
		System.out.println("hello--���Ǿ�̬���� �ұ�C���������=");
	}
	
	
	/**
	 * ��C�������Java����JNI�е�helloFromJava()
	 */
	public native void callBackJava_helloFromJava();
	
	/**
	 * ��C�������Java����JNI�е�add(int x,int y) 
	 */
	public native void callBackJava_add();
	
	/**
	 * ��C�������Java����JNI�е�printString(String s) 
	 */
	public native void callBackJava_printString();
	
	/**
	 * ��C�������Java����JNI�еľ�̬����hello() 
	 */
	public native void callBackJava_hello();


}
