LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := CCallBackJava
LOCAL_SRC_FILES := CCallBackJava.c

include $(BUILD_SHARED_LIBRARY)
