package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;
    static final String[] b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};
    ReaderPreDownloadCallback i;
    Handler a = null;

    /* renamed from: c, reason: collision with root package name */
    LinkedList<String> f944c = new LinkedList<>();
    boolean d = false;
    ReaderWizard e = null;
    TbsReaderView.ReaderCallback f = null;
    Object g = null;
    Context h = null;
    String j = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.i = null;
        this.i = readerPreDownloadCallback;
        for (String str : b) {
            this.f944c.add(str);
        }
        a();
    }

    private void b() {
        b(3);
    }

    boolean a(String str) {
        if (this.g == null || this.e == null || !ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.e.checkPlugin(this.g, this.h, str, true);
    }

    boolean c(int i) {
        return this.a.hasMessages(i);
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.h = context.getApplicationContext();
        boolean a = TbsReaderView.a(context.getApplicationContext());
        TbsReaderView.ReaderCallback readerCallback = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int intValue;
                if (num.intValue() == 5012 && 5014 != (intValue = ((Integer) obj).intValue())) {
                    if (5013 == intValue) {
                        TbsReaderPredownload.this.a(0);
                    } else if (intValue == 0) {
                        TbsReaderPredownload.this.a(0);
                    } else {
                        TbsReaderPredownload.this.a(-1);
                    }
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    tbsReaderPredownload.j = "";
                    tbsReaderPredownload.a(3, 100);
                }
            }
        };
        this.f = readerCallback;
        try {
            if (this.e == null) {
                this.e = new ReaderWizard(readerCallback);
            }
            if (this.g == null) {
                this.g = this.e.getTbsReader();
            }
            Object obj = this.g;
            return obj != null ? this.e.initTbsReader(obj, context.getApplicationContext()) : a;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void pause() {
        this.d = true;
    }

    public void shutdown() {
        this.i = null;
        this.d = false;
        this.f944c.clear();
        b();
        ReaderWizard readerWizard = this.e;
        if (readerWizard != null) {
            readerWizard.destroy(this.g);
            this.g = null;
        }
        this.h = null;
    }

    public void start(String str) {
        this.d = false;
        b(3);
        this.f944c.add(str);
        a(3, 100);
    }

    public void startAll() {
        this.d = false;
        if (!false && !c(3)) {
            a(3, 100);
        }
    }

    void b(int i) {
        this.a.removeMessages(i);
    }

    void a(int i) {
        if (this.i != null) {
            this.i.onEvent(this.j, i, this.f944c.isEmpty());
        }
    }

    void a() {
        this.a = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 3 && !TbsReaderPredownload.this.f944c.isEmpty()) {
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    if (tbsReaderPredownload.d) {
                        return;
                    }
                    String removeFirst = tbsReaderPredownload.f944c.removeFirst();
                    TbsReaderPredownload tbsReaderPredownload2 = TbsReaderPredownload.this;
                    tbsReaderPredownload2.j = removeFirst;
                    if (tbsReaderPredownload2.a(removeFirst)) {
                        return;
                    }
                    TbsReaderPredownload.this.a(-1);
                }
            }
        };
    }

    void a(int i, int i2) {
        this.a.sendMessageDelayed(this.a.obtainMessage(i), i2);
    }
}
