package com.sigmob.sdk.downloader.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m implements Handler.Callback {
    static final int a = 0;
    static final int b = -1;

    /* renamed from: c, reason: collision with root package name */
    static final int f507c = -2;
    static final int d = -3;
    private static final String e = "RemitSyncExecutor";
    private final Handler f;
    private final Set<Integer> g;
    private final a h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    interface a {
        void a(List<Integer> list);

        void h(int i);

        void i(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.h = aVar;
        this.g = new HashSet();
        HandlerThread handlerThread = new HandlerThread("FileDownload RemitHandoverToDB");
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    m(a aVar, Handler handler, Set<Integer> set) {
        this.h = aVar;
        this.f = handler;
        this.g = set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f.getLooper().quit();
    }

    public void a(int i, long j) {
        this.f.sendEmptyMessageDelayed(i, j);
    }

    public void a(List<Integer> list) {
        Message obtainMessage = this.f.obtainMessage(0);
        obtainMessage.obj = list;
        this.f.sendMessage(obtainMessage);
    }

    void a(int[] iArr) {
        for (int i : iArr) {
            this.f.removeMessages(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return this.g.contains(Integer.valueOf(i));
    }

    public void b(int i) {
        this.f.sendEmptyMessage(i);
    }

    public void b(List<Integer> list) {
        Message obtainMessage = this.f.obtainMessage(-1);
        obtainMessage.obj = list;
        this.f.sendMessage(obtainMessage);
    }

    public void c(int i) {
        Message obtainMessage = this.f.obtainMessage(-3);
        obtainMessage.arg1 = i;
        this.f.sendMessage(obtainMessage);
    }

    public void d(int i) {
        Message obtainMessage = this.f.obtainMessage(-2);
        obtainMessage.arg1 = i;
        this.f.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        this.f.removeMessages(i);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        StringBuilder sb;
        String str;
        String str2;
        int i2 = message.what;
        if (i2 == -3) {
            i = message.arg1;
            this.g.remove(Integer.valueOf(i));
            this.h.i(i);
            sb = new StringBuilder();
            str = "remove info ";
        } else {
            if (i2 != -2) {
                if (i2 == -1) {
                    List list = (List) message.obj;
                    this.g.removeAll(list);
                    sb = new StringBuilder();
                    sb.append("remove free bunch ids ");
                    sb.append(list);
                    com.sigmob.sdk.downloader.core.c.b(e, sb.toString());
                    return true;
                }
                if (i2 != 0) {
                    try {
                        this.h.h(i2);
                        this.g.add(Integer.valueOf(i2));
                        com.sigmob.sdk.downloader.core.c.b(e, "sync info with id: " + i2);
                        return true;
                    } catch (IOException unused) {
                        str2 = "sync cache to db failed for id: " + i2;
                    }
                } else {
                    List<Integer> list2 = (List) message.obj;
                    try {
                        this.h.a(list2);
                        this.g.addAll(list2);
                        com.sigmob.sdk.downloader.core.c.b(e, "sync bunch info with ids: " + list2);
                        return true;
                    } catch (IOException unused2) {
                        str2 = "sync info to db failed for ids: " + list2;
                    }
                }
                com.sigmob.sdk.downloader.core.c.a(e, str2);
                return true;
            }
            i = message.arg1;
            this.g.remove(Integer.valueOf(i));
            sb = new StringBuilder();
            str = "remove free bunch id ";
        }
        sb.append(str);
        sb.append(i);
        com.sigmob.sdk.downloader.core.c.b(e, sb.toString());
        return true;
    }
}
