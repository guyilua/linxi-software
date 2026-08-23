package com.rtk.app.main.UpModule.UpControlPack.c;

import com.rtk.app.custom.MarkedImageView;

/* compiled from: UpIconNumSubject.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements c {
    private MarkedImageView a;

    /* compiled from: UpIconNumSubject.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.setMessageNumber(this.a);
        }
    }

    public b(MarkedImageView markedImageView) {
        this.a = markedImageView;
    }

    @Override // com.rtk.app.main.UpModule.UpControlPack.c.c
    public void a(int i) {
        this.a.post(new a(i));
    }
}
