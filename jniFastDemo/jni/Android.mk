LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jniFastDemo
LOCAL_SRC_FILES := jniFastDemo.c

include $(BUILD_SHARED_LIBRARY)
