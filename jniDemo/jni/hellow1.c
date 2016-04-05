#include<stdio.h>
#include<stdlib.h>
#include<com_example_jnidemo_MainActivity.h>

/**
 *jstring：返回值，String -jstring -String
 *方法名：
 *Java_全类名(把.变成_)_方法名
 *JNIEnv* env：const struct JNINativeInterface**
 *  (*env).等价于 env->
    (**env).等价  (*env)->
 *
 *jobj：谁调用这个方法就是谁的实例，当前是MainActivity.this
 *
 */

jstring Java_com_example_jnidemo_MainActivity_say_1133_1Hello(JNIEnv* env,jobject jobj){
	//jstring     (*NewStringUTF)(JNIEnv*, const char*);
	char* text = "I am from C!!! use (**env).add javah头文件";
	return (**env).NewStringUTF(env,text);
}
