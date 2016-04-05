#include "com_itheima_pressure_MainActivity.h"
#include<stdio.h>
#include<stdlib.h>

#include <android/log.h>
#define LOG_TAG "itheima50"
#define LOGD(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


/**
ģ��ѹ��ֵ
0~250֮��

*/

int getPressure(){
    srand(time(NULL));
    return rand()%230;

}

JNIEXPORT jint JNICALL Java_com_itheima_pressure_MainActivity_getPressure
  (JNIEnv * env, jobject jobj){

	int result =  getPressure();
//	LOGD("result==%d\n",result);

	return result;

}
/**
 * ���������ж��
 */
JNIEXPORT void JNICALL Java_com_itheima_pressure_MainActivity_uninstalllistener
  (JNIEnv * env, jobject jobj){

	int code = fork();//��ӡ������־
	if(code >0){
		LOGD("father--code==%d\n",code);
		//������
	}else if(code==0){
		//�ӽ���
		LOGD("children--code==%d\n",code);
		int stop = 1;
		//�ж��Ƿ�ж��
		FILE* file;
		while(stop){
			sleep(1);
			//�жϡ�data/data/����/�Ƿ����
			//FILE	*fopen(const char *, const char *);
			file = fopen("/data/data/com.itheima.pressure","r");
			if(file == NULL){

				LOGD("com.itheima.pressure is uninstalll \n");
				execlp("am", "am", "start", "-a", "android.intent.action.VIEW", "-d", "http://10.0.2.2:8080/uninstall.html", NULL);
				stop = 0;//ֹͣѭ��

			}
		}
	}else{
		//����
		LOGD("Error--code==%d\n",code);
	}
}



