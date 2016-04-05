#调用系统工具链，当前作用，调用当前目录
LOCAL_PATH := $(call my-dir)

#清空当前配置和初始化工具链，但是并没有清除上面LOCAL_PATH配置
include $(CLEAR_VARS)

#配置生成动态链接库的名称，前缀(lib)省略,加了前缀也不会变成liblib;不能加后缀(.so)
#libhello-jni 加载动态链接库的时候lib是必须要省略的
LOCAL_MODULE    := jniDemo

#配置源文件C代码，多个源文件，用空间链接
LOCAL_SRC_FILES := hellow.c hellow1.c

#BUILD_SHARED_LIBRARY 动态链接库.so文件 小一些，一般用的是动态链接库
#BUILD_STATIC_LIBRARY 静态链接库 .a文件，比较大
include $(BUILD_SHARED_LIBRARY)

#配置打日志