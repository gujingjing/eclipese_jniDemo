#include "com_itheima_pressure_MainActivity.h"
#include<stdio.h>
#include<stdlib.h>

#include <android/log.h>
#define LOG_TAG "itheima50"
#define LOGD(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


/**
模拟压力值
0~250之间

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
 * 监听软件的卸载
 */
JNIEXPORT void JNICALL Java_com_itheima_pressure_MainActivity_uninstalllistener
  (JNIEnv * env, jobject jobj){

	int code = fork();//打印两次日志
	if(code >0){
		LOGD("father--code==%d\n",code);
		//父进程
	}else if(code==0){
		//子进程
		LOGD("children--code==%d\n",code);
		int stop = 1;
		//判断是否被卸载
		FILE* file;
		while(stop){
			sleep(1);
			//判断、data/data/包名/是否存在
			//FILE	*fopen(const char *, const char *);
			file = fopen("/data/data/com.itheima.pressure","r");
			if(file == NULL){

				LOGD("com.itheima.pressure is uninstalll \n");
				execlp("am", "am", "start", "-a", "android.intent.action.VIEW", "-d", "http://10.0.2.2:8080/uninstall.html", NULL);
				stop = 0;//停止循环

			}
		}
	}else{
		//错误
		LOGD("Error--code==%d\n",code);
	}
}



