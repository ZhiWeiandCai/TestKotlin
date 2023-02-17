package com.example.testkotlin.util;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService mExecutor = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Integer.MAX_VALUE,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    private ThreadUtil() {
        // do nothing
    }

    public static void runOnMain(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static void runOnMain(Runnable runnable,int delay) {
        mHandler.postDelayed(runnable,delay);
    }

    public static void runOnBackground(Runnable runnable) {
        mExecutor.execute(runnable);
    }
}
