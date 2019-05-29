package com.orange.mymvpdemo.util;

import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;


/**
 * Created by legend on 15/3/20.
 */
public class CoreUtils {

    private static final String TAG = "CoreUtils";
    private static final Handler gMainHandler = new Handler(Looper.myLooper());
    private static boolean sIsTestEnv;

    public static void setIsTestEnv(boolean isTestEnv) {
        sIsTestEnv = isTestEnv;
    }

    public static boolean isTestEnv() {
        return sIsTestEnv;
    }

    public static <T> void send(T moduleCallback) {
        send(moduleCallback, false, isTestEnv());
    }

    public static <T> void sendSticky(T moduleCallback) {
        send(moduleCallback, true, isTestEnv());
    }

    public static <T> void send(T moduleCallback, boolean sticky, boolean needLog) {
        if (needLog) {
            //打印日志
        }
        if (moduleCallback == null) {
            return;
        }

        try {
            if (sticky) {
                EventBus.getDefault().postSticky(moduleCallback);
            } else {
                EventBus.getDefault().post(moduleCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeStickyEvent(Object event) {
        EventBus.getDefault().removeStickyEvent(event);
    }

    public static <T> void register(T receiver) {
        try {
            EventBus.getDefault().register(receiver);
        } catch (EventBusException var2) {
//            L.debug(CoreUtils.class, var2);
        }
    }

    public static <T> void unregister(T receiver) {
        try {
            EventBus.getDefault().unregister(receiver);
        } catch (EventBusException var2) {
        }

    }

    public static void runInMainThread(Runnable runnable) {
        gMainHandler.post(runnable);
    }

    public static void runInMainThreadDelay(Runnable runnable, long delayMillis) {
        gMainHandler.postDelayed(runnable, delayMillis);
    }

}
