LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ithiema50
LOCAL_SRC_FILES := ithiema50.c

LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)
