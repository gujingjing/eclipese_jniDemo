package com.example.javacallcdemo;

public class JNI {
	{
		System.loadLibrary("javaCallCDemo");
	}

	/**
	 * 让C代码执行加法运算，把结果回传个Java代码并且显示
	 * @param x
	 * @param y
	 * @return
	 */
	public native int add(int x, int y);

	/**
	 * 让C代码执行字符串运算，Java中传入的字符串末尾添加 add from C 
	 * @param s
	 * @return
	 */
	public native String sayHelloInC(String s);

	/**
	 * Java传入数组，让C代码运算，每个元素加上10，Java把值打印出来
	 * @param intArray
	 * 应用场景：颜色矩阵，数组，C代码吧数组改变了
	 * @return
	 */
	public native int[] arrElementsIncrease(int[] intArray);

}
