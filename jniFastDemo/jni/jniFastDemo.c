#include<stdio.h>
#include<stdlib.h>
#include <com_example_jnifastdemo_MainActivity.h>


JNIEXPORT jstring JNICALL Java_com_example_jnifastdemo_MainActivity_sayHello
  (JNIEnv * env, jobject jobj){

	//jstring     (*NewStringUTF)(JNIEnv*, const char*);
		char* text = "simple develop";
		return (**env).NewStringUTF(env,text);
}
