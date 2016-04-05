#include<stdio.h>
#include<stdlib.h>
#include <com_example_javacallcdemo_JNI.h>

#include <android/log.h>
#define LOG_TAG "gjj-"
#define LOGD(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

/**
 * ��һ��jstringת����һ��c���Ե�char* ����.
 */
char* _JString2CStr(JNIEnv* env, jstring jstr) {
	 char* rtn = NULL;
	 jclass clsstring = (*env)->FindClass(env, "java/lang/String");
	 jstring strencode = (*env)->NewStringUTF(env,"GB2312");
	 jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
	 jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid, strencode); // String .getByte("GB2312");
	 jsize alen = (*env)->GetArrayLength(env, barr);
	 jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
	 if(alen > 0) {
		rtn = (char*)malloc(alen+1); //"\0"
		memcpy(rtn, ba, alen);
		rtn[alen]=0;
	 }
	 (*env)->ReleaseByteArrayElements(env, barr, ba,0);
	 return rtn;
}


JNIEXPORT jint JNICALL Java_com_example_javacallcdemo_JNI_add
  (JNIEnv *env, jobject jobj , jint jx, jint jy){

	jint result = jx + jy;
	printf("printf--result==%d\n",result);//���ܴ򵽿���̨
	LOGD("LOGD--result==%d\n",result);

	return result;

}

/**
 * ��C����ִ���ַ������㣬Java�д�����ַ���ĩβ����" add from C "
 */
JNIEXPORT jstring JNICALL Java_com_example_javacallcdemo_JNI_sayHelloInC
  (JNIEnv * env, jobject jobj, jstring jstr){
	//jstring -->char*
	char* text = _JString2CStr(env,jstr);
	char* content = " add from C for gjj!!!";
	//��text��contentƴ�����������Ұ�ƴ�ӵĽ����text
	strcat(text,content);

	//jstring     (*NewStringUTF)(JNIEnv*, const char*);
	return (*env)->NewStringUTF(env,text);
}


/**
 *  Java�������飬��C�������㣬ÿ��Ԫ�ؼ���10��Java��ֵ��ӡ����
 */
JNIEXPORT jintArray JNICALL Java_com_example_javacallcdemo_JNI_arrElementsIncrease
  (JNIEnv * env, jobject jobj, jintArray jarray){

	//1.�õ�����ĳ���
	 //jsize       (*GetArrayLength)(JNIEnv*, jarray);
	jsize length = (*env)->GetArrayLength(env,jarray);

	//2.����ÿһ��Ԫ��
	//jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
	jint* jints = (*env)->GetIntArrayElements(env,jarray,JNI_FALSE);


	int i;
	for(i=0;i<length;i++){
		//3.ÿ��Ԫ�ؼ���10
		*(jints+i) += 10;

	}

	return jarray;

}