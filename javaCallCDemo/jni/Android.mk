LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := javaCallCDemo
LOCAL_SRC_FILES := javaCallCDemo.c

#配置支持在C代码打日志
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)
