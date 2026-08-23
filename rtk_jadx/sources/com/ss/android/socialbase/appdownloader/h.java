package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private final Queue<Integer> a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private long f823c;
    private long d;
    private SoftReference<JumpUnknownSourceActivity> e;
    private Handler f;
    private Runnable g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static final h a = new h();
    }

    private h() {
        this.a = new ArrayDeque();
        this.b = false;
        this.f = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0086a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void b() {
                if (h.this.a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - h.this.d;
                if (currentTimeMillis < a2) {
                    if (h.this.f.hasCallbacks(h.this.g)) {
                        return;
                    }
                    h.this.f.postDelayed(h.this.g, a2 - currentTimeMillis);
                } else {
                    h.this.d = System.currentTimeMillis();
                    h.this.c();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i, boolean z) {
        int b = c.b(context, i, z);
        if (b == 1) {
            this.b = true;
        }
        this.f823c = System.currentTimeMillis();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b()) {
            synchronized (this.a) {
                poll = this.a.poll();
            }
            this.f.removeCallbacks(this.g);
            if (poll != null) {
                final Context O = com.ss.android.socialbase.downloader.downloader.c.O();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.b(O, poll.intValue(), false);
                        }
                    });
                } else {
                    b(O, poll.intValue(), false);
                }
                this.f.postDelayed(this.g, 20000L);
                return;
            }
            this.b = false;
        }
    }

    private boolean d() {
        return System.currentTimeMillis() - this.f823c < 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.e = null;
        return jumpUnknownSourceActivity;
    }

    public static h a() {
        return a.a;
    }

    public int a(final Context context, final int i, final boolean z) {
        if (z) {
            return b(context, i, z);
        }
        if (d()) {
            this.f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.a.a.a().b()) {
            com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
            return b(context, i, z);
        }
        if (b.a()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.a.isEmpty() && !this.b && z2) {
            return b(context, i, z);
        }
        int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
        synchronized (this.a) {
            while (this.a.size() > a2) {
                this.a.poll();
            }
        }
        if (z2) {
            this.f.removeCallbacks(this.g);
            this.f.postDelayed(this.g, com.ss.android.socialbase.downloader.g.a.a(i).a("install_queue_timeout", 20000L));
        }
        synchronized (this.a) {
            if (!this.a.contains(Integer.valueOf(i))) {
                this.a.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.e = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
