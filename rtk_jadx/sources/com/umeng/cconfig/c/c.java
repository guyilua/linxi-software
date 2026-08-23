package com.umeng.cconfig.c;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class c {
    private static BlockingQueue<Runnable> d = new ArrayBlockingQueue(64);
    private static int a = 8;
    private static int b = 64;

    /* renamed from: c, reason: collision with root package name */
    private static int f1078c = 5;
    private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, f1078c, TimeUnit.SECONDS, d);

    public static void a(Runnable runnable) {
        e.execute(runnable);
    }
}
