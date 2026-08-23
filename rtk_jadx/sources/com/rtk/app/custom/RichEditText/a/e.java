package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.style.ImageSpan;

/* compiled from: RichImgSpan.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends ImageSpan {
    private String a;

    public e(Context context, Bitmap bitmap, String str) {
        super(context, bitmap);
        this.a = str;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // android.text.style.ImageSpan
    public String getSource() {
        return this.a;
    }
}
