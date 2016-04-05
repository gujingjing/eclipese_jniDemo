#include <com_example_ccallbackjava_JNI.h>
#include<stdio.h>
#include<stdlib.h>

/**
 * ��C�������Java����JNI�е�helloFromJava()
 */
JNIEXPORT void JNICALL Java_com_example_ccallbackjava_JNI_callBackJava_1helloFromJava
(JNIEnv * env, jobject jobj) {

	//�÷���
	//1.�õ��ֽ���
	//jclass      (*FindClass)(JNIEnv*, const char*);
	//Ҫʵ���������ȫ����,Ҫ��.�ĳ�/    com.example.ccallbackjava.JNI
	jclass jclazz = (*env)->FindClass(env,"com/example/ccallbackjava/JNI");

	//2.�õ���Ӧ�ķ���
	// jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	//�����ڶ���������������
	//���һ������������ǩ��
	jmethodID jmethodIDs = (*env)->GetMethodID(env,jclazz,"helloFromJava","()V");

	//3.�õ�ʵ��
	//jobject     (*AllocObject)(JNIEnv*, jclass);
	jobject jobject= (*env)->AllocObject(env,jclazz);

	//4.ִ��
	//  void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
	(*env)->CallVoidMethod(env,jobject,jmethodIDs);// �ɹ�������Java��JNI��helloFromJava()��

}


/**
 *  ��C�������Java����JNI�е�add(int x,int y)
 */
JNIEXPORT void JNICALL Java_com_example_ccallbackjava_JNI_callBackJava_1add
  (JNIEnv * env, jobject jobj){


	//�÷���
	//1.�õ��ֽ���
	//jclass      (*FindClass)(JNIEnv*, const char*);
	//Ҫʵ���������ȫ����,Ҫ��.�ĳ�/
	jclass jclazz = (*env)->FindClass(env,"com/example/ccallbackjava/JNI");

	//2.�õ���Ӧ�ķ���
	// jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	//�����ڶ���������������
	//���һ������������ǩ��
	jmethodID jmethodIDs = (*env)->GetMethodID(env,jclazz,"add","(II)I");

	//3.�õ�ʵ��
	//jobject     (*AllocObject)(JNIEnv*, jclass);
	jobject jobject= (*env)->AllocObject(env,jclazz);

	//4.ִ��
	//   jint        (*CallIntMethod)(JNIEnv*, jobject, jmethodID, ...);
	(*env)->CallIntMethod(env,jobject,jmethodIDs,99,1);//�ɹ�������Java��JNI���е�add(int x,int y)



}

/**
 * ��C�������Java����JNI�е�printString(String s)
 */
JNIEXPORT void JNICALL Java_com_example_ccallbackjava_JNI_callBackJava_1printString
  (JNIEnv * env, jobject jobj){

	//�÷���
	//1.�õ��ֽ���
	//jclass      (*FindClass)(JNIEnv*, const char*);
	//Ҫʵ���������ȫ����,Ҫ��.�ĳ�/
	jclass jclazz = (*env)->FindClass(env,"com/example/ccallbackjava/JNI");

	//2.�õ���Ӧ�ķ���
	// jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	//�����ڶ���������������
	//���һ������������ǩ��
	jmethodID jmethodIDs = (*env)->GetMethodID(env,jclazz,"printString","(Ljava/lang/String;)V");

	//3.�õ�ʵ��
	//jobject     (*AllocObject)(JNIEnv*, jclass);
	jobject jobject= (*env)->AllocObject(env,jclazz);

	//4.ִ��
	//    void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
	//char* ---��jstring
	//jstring     (*NewStringUTF)(JNIEnv*, const char*);
	char* text = "I am from C for afu";
	jstring jstr= (*env)->NewStringUTF(env,text);
	(*env)->CallVoidMethod(env,jobject,jmethodIDs,jstr);//�ɹ�������Java��JNI���е�printString(String s)
}

/**
 *  ��C�������Java����JNI�еľ�̬����hello()
 */
JNIEXPORT void JNICALL Java_com_example_ccallbackjava_JNI_callBackJava_1hello
  (JNIEnv * env, jobject jobj){


	//�÷���
	//1.�õ��ֽ���
	//jclass      (*FindClass)(JNIEnv*, const char*);
	//Ҫʵ���������ȫ����,Ҫ��.�ĳ�/
	jclass jclazz = (*env)->FindClass(env,"com/example/ccallbackjava/JNI");

	//2.�õ���Ӧ�ķ���
	// jmethodID   (*GetStaticMethodID)(JNIEnv*, jclass, const char*, const char*);
	//�����ڶ���������������
	//���һ������������ǩ��
	jmethodID jmethodIDs = (*env)->GetStaticMethodID(env,jclazz,"hello","()V");

	//3.ִ��
	//   void        (*CallStaticVoidMethod)(JNIEnv*, jclass, jmethodID, ...);
	(*env)->CallStaticVoidMethod(env,jclazz,jmethodIDs);//�ɹ�������Java��JNI���е�hello()


}