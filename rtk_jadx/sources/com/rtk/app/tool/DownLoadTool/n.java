package com.rtk.app.tool.DownLoadTool;

import com.rtk.app.custom.MarkedImageView;

/* compiled from: DownLoadBtuMySubject.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n implements o {
    private MarkedImageView a;

    /* compiled from: DownLoadBtuMySubject.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a.setMessageNumber(this.a);
        }
    }

    public n(MarkedImageView markedImageView) {
        this.a = markedImageView;
    }

    @Override // com.rtk.app.tool.DownLoadTool.o
    public void a(int i) {
        this.a.post(new a(i));
    }
}
