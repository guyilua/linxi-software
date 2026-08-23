package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    static final a a = new C0080b();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.g.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class C0080b extends a {
        private C0080b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        a.a(asyncTask, tArr);
    }
}
