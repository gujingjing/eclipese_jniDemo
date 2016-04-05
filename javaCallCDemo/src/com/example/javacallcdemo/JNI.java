package com.example.javacallcdemo;

public class JNI {
	{
		System.loadLibrary("javaCallCDemo");
	}

	/**
	 * ��C����ִ�мӷ����㣬�ѽ���ش���Java���벢����ʾ
	 * @param x
	 * @param y
	 * @return
	 */
	public native int add(int x, int y);

	/**
	 * ��C����ִ���ַ������㣬Java�д�����ַ���ĩβ���� add from C 
	 * @param s
	 * @return
	 */
	public native String sayHelloInC(String s);

	/**
	 * Java�������飬��C�������㣬ÿ��Ԫ�ؼ���10��Java��ֵ��ӡ����
	 * @param intArray
	 * Ӧ�ó�������ɫ�������飬C���������ı���
	 * @return
	 */
	public native int[] arrElementsIncrease(int[] intArray);

}