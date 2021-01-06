package com.arron.searchdemo.util;

import android.util.Log;

import com.arron.searchdemo.BuildConfig;

import java.util.Locale;

/**
 * create by Aaron Xie
 * on 2020/11/10
 * description:
 */
public class LogUtil {
    private static String className;//类名
    private static String methodName;//方法名
    private static int lineNumber;//行数

    /**
     * 判断是否可以调试
     *
     * @return 可以调试 true ,不可以 false
     */
    private static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog(String log) {
        return String.format(Locale.getDefault(),
                "%s(%s:%d)=======================>%s"
                , methodName, className, lineNumber, log);
    }

    /**
     * 获取文件名、方法名、所在行数
     *
     * @param sElements 日志元素
     */
    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.e(className, createLog(message));
        }
    }

    public static void i(String message) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.i(className, createLog(message));
        }
    }

    public static void d(String message) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.d(className, createLog(message));
        }
    }

    public static void v(String message) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.v(className, createLog(message));
        }
    }

    public static void w(String message) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.w(className, createLog(message));
        }
    }
}
