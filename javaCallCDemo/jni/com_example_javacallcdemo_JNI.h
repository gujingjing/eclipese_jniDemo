/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_example_javacallcdemo_JNI */

#ifndef _Included_com_example_javacallcdemo_JNI
#define _Included_com_example_javacallcdemo_JNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_javacallcdemo_JNI
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_example_javacallcdemo_JNI_add
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_example_javacallcdemo_JNI
 * Method:    sayHelloInC
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_javacallcdemo_JNI_sayHelloInC
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_example_javacallcdemo_JNI
 * Method:    arrElementsIncrease
 * Signature: ([I)[I
 */
JNIEXPORT jintArray JNICALL Java_com_example_javacallcdemo_JNI_arrElementsIncrease
  (JNIEnv *, jobject, jintArray);

#ifdef __cplusplus
}
#endif
#endif
